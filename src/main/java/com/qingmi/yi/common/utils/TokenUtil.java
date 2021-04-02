package com.qingmi.yi.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.qingmi.yi.common.exception.CenterException;
import com.qingmi.yi.common.exception.msg.CenterErrorMsg;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.security.model.SysUserAuthentication;
import jodd.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: 李龙真
 * @Date: 2020/12/22 18:42
 */
public class TokenUtil {
    public static Long getTokenUserId() {
        String token = getRequest().getHeader("token");// 从 http 请求头中取出 token
        if(StringUtil.isEmpty(token)){
            //throw new CenterException(CenterErrorMsg.TokenIsFreezeException);
        }
        return Long.parseLong(JWT.decode(token).getAudience().get(0));
    }

    public static String getToken(CustomerUser user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 100000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId().toString()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getOpenid()));
        return token;
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
