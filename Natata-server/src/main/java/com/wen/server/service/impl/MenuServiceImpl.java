package com.wen.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.server.entity.Admin;
import com.wen.server.entity.Menu;
import com.wen.server.mapper.MenuMapper;
import com.wen.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Menu> getMenuByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        //从redis获取菜单数据
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        //如果为空,从数据库中获取
        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenuByAdminId(adminId);
            //将数据返回到redis
            valueOperations.set("menu_" + adminId, menus);
        }
        return menus;
    }
}
