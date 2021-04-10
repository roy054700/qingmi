package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 客户-用户
 * @Author: 李龙真
 * @Date: 2021/3/11 13:30
 */
@Data
@TableName("customer_user")
public class CustomerUser {
    /**
     * ID号
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 微信id
     */
    private String openid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private int sex;

    /**
     * 性别名称
     */

    private String sexname;

    /**
     * 简介
     */
    private String briefIntroduction;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 所在城市
     */
    private String city;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * bitmap头像
     */
    private String bitmapHead;
    /**
     * 账号是否冻结 0 正常，1冻结
     */
    private int frozen;

    //关注的人数
    @TableField(exist = false)
    private int followCount;
    //被关注的人数
    @TableField(exist = false)
    private int coverFollowCount;

}
