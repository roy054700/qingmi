package com.qingmi.yi.security.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 认证用户主体模型，用户信息
 * @Author: 李龙真
 * @Date: 2020/12/21 16:15
 */
@Data
@TableName("customer_user")
public class SysUserAuthentication extends Model implements UserDetails {
    private static final long serialVersionUID = 5698641074914331015L;

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
    private String wechatId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 简介
     */
    private String brief_introduction;
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
    private String phone_number;

    /**
     * 头像
     */
    private String head_portrait;//
    /**
     * 账号是否冻结 0 正常，1冻结
     */
    private int frozen;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户生效
     */
    @TableField(exist = false)
    private boolean accountNonExpired;
    /**
     * 账户锁定
     */
    @TableField(exist = false)
    private boolean accountNonLocked;
    /**
     * 凭证生效
     */
    @TableField(exist = false)
    private boolean credentialsNonExpired;
    /**
     * 激活状态
     */
    @TableField(exist = false)
    private boolean enabled;
    /**
     * 权限列表
     */
    @TableField(exist = false)
    private Collection<GrantedAuthority> authorities;

}
