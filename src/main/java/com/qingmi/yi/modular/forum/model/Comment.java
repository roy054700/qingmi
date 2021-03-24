package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 作品评论
 * @Author: 李龙真
 * @Date: 2021/3/10 11:18
 */
@Data
@TableName("o_comment")
public class Comment {
    private Long id;//主键
    private Long workId;//作品id
    private Long parentId;//父id
    private String commentContent;//评论内容
    private Long createUserId;//创建人id
    private Date createTime;//创建时间

    /**
     * 用户名
     */
    @TableField(exist = false)
    private String username;
    /**
     * 头像
     */
    @TableField(exist = false)
    private String headPortrait;

    @TableField(exist = false)
    private List<Comment> list;


}
