package com.qingmi.yi.security.mapper;

import com.qingmi.yi.security.model.SysUserAuthentication;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 李龙真
 * @Date: 2020/12/22 17:48
 */
@Mapper
public interface  UserMapper {

    SysUserAuthentication findByUsername(String username);

    SysUserAuthentication findUserById(String id);
}
