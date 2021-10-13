package com.wen.server.mapper;

import com.wen.server.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wen
 * @since 2021-10-03
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据用户id获取menu
     * @param id 用户id
     * @return
     */
    List<Menu> getMenuByAdminId(Integer id);
}
