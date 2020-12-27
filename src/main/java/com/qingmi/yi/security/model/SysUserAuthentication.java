package com.qingmi.yi.security.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 认证用户主体模型
 * @Author: 李龙真
 * @Date: 2020/12/21 16:15
 */
@Data
public class SysUserAuthentication extends Model implements UserDetails {
    private static final long serialVersionUID = 5698641074914331015L;

    /**
     * ID号
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户生效
     */
    private boolean accountNonExpired;
    /**
     * 账户锁定
     */
    private boolean accountNonLocked;
    /**
     * 凭证生效
     */
    private boolean credentialsNonExpired;
    /**
     * 激活状态
     */
    private boolean enabled;
    /**
     * 权限列表
     */
    private Collection<GrantedAuthority> authorities;

}
