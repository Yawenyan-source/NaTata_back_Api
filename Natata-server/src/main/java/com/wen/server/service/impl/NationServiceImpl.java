package com.wen.server.service.impl;

import com.wen.server.entity.Nation;
import com.wen.server.mapper.NationMapper;
import com.wen.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
