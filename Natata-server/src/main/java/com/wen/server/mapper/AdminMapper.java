package com.wen.server.mapper;

import com.wen.server.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wen.server.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
