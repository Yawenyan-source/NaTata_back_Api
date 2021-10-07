package com.wen.server.service.impl;

import com.wen.server.entity.Department;
import com.wen.server.mapper.DepartmentMapper;
import com.wen.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
