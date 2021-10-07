package com.wen.server.service.impl;

import com.wen.server.entity.Employee;
import com.wen.server.mapper.EmployeeMapper;
import com.wen.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
