package com.qingmi.yi.modular.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingmi.yi.modular.forum.model.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论
 * @Author: 李龙真
 * @Date: 2021/3/10 16:18
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
