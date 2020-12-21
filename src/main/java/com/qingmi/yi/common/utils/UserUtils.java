package com.qingmi.yi.common.utils;

import com.qingmi.yi.common.constant.ConstantToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@Slf4j
public class UserUtils {
    /**
     * 获取请求中的token
     *
     * @param request
     * @return token
     */
    public static String getToken(HttpServletRequest request) {
        String authorizationToken = request.getHeader(ConstantToken.AUTHORIZATION_KEY);
        if (StringUtils.isNotBlank(authorizationToken)) {
            return authorizationToken.substring("Bearer".length(),authorizationToken.length()).trim();
        }
        String token = request.getHeader(ConstantToken.TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(ConstantToken.TOKEN_KEY);
        }
        if(StringUtils.isNotBlank(token)){
            token = token.substring("Bearer".length(),token.length()).trim();
        }
        log.info("获取token成功，值为{}", token);
        return token;
    }

    /**
     * 获取请求客户端type
     * @param request
     * @return clientType
     */
    public static String getClientType(HttpServletRequest request) {
        String clientType = request.getHeader(ConstantToken.CLIENT_TYPE);
        if (StringUtils.isNotBlank(clientType)) {
            return clientType;
        }
        clientType = request.getParameter(ConstantToken.CLIENT_TYPE);
        log.info("获取客户端clientType成功，值为{}", clientType);
        return clientType;
    }

    /**
     * 获取请求中的userId
     * @param request
     * @return userId
     */
    public static String getUserId(HttpServletRequest request){
        String token = getToken(request);
        if(token == null){
            return null;
        }
        Claims claims = getClaims(token);
        String userId = String.valueOf(claims.get(ConstantToken.USER_ID).toString());
        log.info("获取userId成功，值为{}", userId);
        return userId;
    }

    /**
     * 获取请求中的get用户类型
     * @param request
     * @return userType
     */
    public static Integer getUserType(HttpServletRequest request) {
        String userType = request.getHeader(ConstantToken.USER_TYPE);
        if (StringUtils.isNotBlank(userType)) {
            return  Integer.parseInt(userType);
        }
        userType = request.getParameter(ConstantToken.USER_TYPE);
        log.info("获取userType成功，值为{}", userType);
        if (StringUtils.isNotBlank(userType)) {
            return  Integer.parseInt(userType);
        }
        return null;
    }

    /**
     * 获取请求中的userName
     * @param request
     * @return username
     */
    public static String getUserName(HttpServletRequest request) {
        String token = getToken(request);
        if (token == null) {
            return null;
        }
        Claims claims = getClaims(token);
        String username = (String) claims.get(ConstantToken.USER_NAME);
        log.info("获取username成功，值为{}", username);
        return  username;
    }

    /**
     * 获取jwt中的claims信息
     * @param token
     * @return claim
     */
    public static Claims getClaims(String token) {
        String key = Base64.getEncoder().encodeToString(ConstantToken.JWT_SECRET.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 获取请求中的AUTHORITIES集合
     * @param request
     * @return AUTHORITIES
     */
    public static List<String> getAuthorities(HttpServletRequest request) {
        String token = getToken(request);
        if(token == null){
            return null;
        }
        Claims claims = getClaims(token);
        List<String> authorities = (List<String>) claims.get(ConstantToken.AUTHORITIES);
        return authorities;
    }
}
