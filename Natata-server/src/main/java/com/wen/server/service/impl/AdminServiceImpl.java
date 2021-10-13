package com.wen.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.server.config.security.JwtTokenUtils;
import com.wen.server.entity.Admin;
import com.wen.server.entity.RespEntity;
import com.wen.server.mapper.AdminMapper;
import com.wen.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    @Qualifier("myUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AdminMapper adminMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录之后返回token
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求
     * @return 返回成功或者失败的信息
     */
    @Override
    public RespEntity login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        System.out.println("收到的验证码是" + captcha);
        if (!StringUtils.hasLength(code) || !captcha.equalsIgnoreCase(code)) {
            return RespEntity.error("验证码输入错误,请重新输入!!!");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //判断传进来的username存不存在和传进来的密码是否匹配
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespEntity.error("用户名或密码不正确");
        }
        //判断账号是否被禁用
        if (!userDetails.isEnabled()) {
            return RespEntity.error("账号被禁用,请联系管理员");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //生成token
        String token = jwtTokenUtils.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespEntity.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户 实现类
     *
     * @param username 用户名
     * @return 返回查询到的用户信息
     */
    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username)
                .eq("enable", true));
    }
}
