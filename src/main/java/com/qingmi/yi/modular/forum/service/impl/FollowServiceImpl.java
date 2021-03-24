package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.FollowMapper;
import com.qingmi.yi.modular.forum.model.Follow;
import com.qingmi.yi.modular.forum.service.FollowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 李龙真
 * @Date: 2021/3/12 16:17
 */
@Service
@Transactional
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
}
