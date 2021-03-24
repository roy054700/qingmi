package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.FabulousMapper;
import com.qingmi.yi.modular.forum.model.Fabulous;
import com.qingmi.yi.modular.forum.service.FabulousService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作品点赞
 * @Author: 李龙真
 * @Date: 2021/3/10 16:48
 */
@Service
@Transactional
public class FabulousServiceImpl extends ServiceImpl<FabulousMapper, Fabulous> implements FabulousService {
}
