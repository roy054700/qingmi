package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.WorksMapper;
import com.qingmi.yi.modular.forum.model.Works;
import com.qingmi.yi.modular.forum.service.WorksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作品
 * @Author: 李龙真
 * @Date: 2021/3/10 16:38
 */
@Service
@Transactional
public class WorksServiceImpl extends ServiceImpl<WorksMapper, Works> implements WorksService {
}
