package com.qingmi.yi.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.qingmi.yi.security.model.SysUserAuthentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * token 下发
 * @Author: 李龙真
 * @Date: 2020/12/22 17:51
 */
@Service
public class TokenService {

    public String getToken(SysUserAuthentication user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 10000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId().toString()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getUsername()));
        return token;
    }
}
