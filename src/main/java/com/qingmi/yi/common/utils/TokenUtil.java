package com.qingmi.yi.common.utils;

import com.auth0.jwt.JWT;
import jodd.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 李龙真
 * @Date: 2020/12/22 18:42
 */
public class TokenUtil {
    public static Long getTokenUserId() {
        String token = getRequest().getHeader("token");// 从 http 请求头中取出 token
        if(StringUtil.isEmpty(token)){
            return 1l;
        }
        String userId = JWT.decode(token).getAudience().get(0);
        return Long.parseLong(userId);
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
