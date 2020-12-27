package com.qingmi.yi.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 授权权限模型
 * @Author: 李龙真
 * @Date: 2020/12/21 16:12
 */
@Data
public class SysGrantedAuthority extends Model implements GrantedAuthority {
 private static final long serialVersionUID = 5698641074914331015L;
    /**
    * 权限
    */
      private String authority;

}
