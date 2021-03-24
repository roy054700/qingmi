package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.CollectionMapper;
import com.qingmi.yi.modular.forum.model.WorkCollection;
import com.qingmi.yi.modular.forum.service.CollectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作品收藏
 * @Author: 李龙真
 * @Date: 2021/3/10 16:50
 */
@Service
@Transactional
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, WorkCollection> implements CollectionService {
}
