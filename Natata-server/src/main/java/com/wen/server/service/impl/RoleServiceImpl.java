package com.wen.server.service.impl;

import com.wen.server.entity.Role;
import com.wen.server.mapper.RoleMapper;
import com.wen.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
