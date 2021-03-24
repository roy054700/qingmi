package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

/**
 * 作品表
 * @Author: 李龙真
 * @Date: 2021/3/10 11:29
 */
@Data
@TableName("o_works")
public class Works {
    private Long id;//主键'
    private int workType;
    private String workName;//作品名称',
    private String workContent;//作品内容',
    private Long createUserId;//创建人id',
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    public boolean like = false;

    @TableField(exist = false)
    public boolean concern = false;
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
}
