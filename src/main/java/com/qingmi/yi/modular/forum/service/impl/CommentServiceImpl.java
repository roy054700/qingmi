package com.qingmi.yi.modular.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.forum.mapper.CommentMapper;
import com.qingmi.yi.modular.forum.model.Comment;
import com.qingmi.yi.modular.forum.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评论
 * @Author: 李龙真
 * @Date: 2021/3/10 16:49
 */
@Service
@Transactional
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
