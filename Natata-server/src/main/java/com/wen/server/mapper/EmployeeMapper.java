package com.wen.server.mapper;

import com.wen.server.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
