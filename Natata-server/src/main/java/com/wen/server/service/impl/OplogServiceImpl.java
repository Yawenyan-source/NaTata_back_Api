package com.wen.server.service.impl;

import com.wen.server.entity.Oplog;
import com.wen.server.mapper.OplogMapper;
import com.wen.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
