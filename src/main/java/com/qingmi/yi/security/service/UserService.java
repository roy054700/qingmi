package com.qingmi.yi.security.service;

import com.qingmi.yi.security.mapper.UserMapper;
import com.qingmi.yi.security.model.SysUserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 李龙真
 * @Date: 2020/12/22 17:50
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public SysUserAuthentication findByUsername(SysUserAuthentication user){
        return userMapper.findByUsername(user.getUsername());
    }
    public SysUserAuthentication findUserById(String userId) {
        return userMapper.findUserById(userId);
    }
}
