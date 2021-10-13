package com.wen.server.service;

import com.wen.server.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据用户id查询用户列表
     *
     * @return
     */
    List<Menu> getMenuByAdminId();
}
