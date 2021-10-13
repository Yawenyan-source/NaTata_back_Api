package com.wen.server.service;

import com.wen.server.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wen.server.entity.RespEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求
     * @return
     */
    RespEntity login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return
     */
    Admin getAdminByUsername(String username);
}
