package com.qingmi.yi.common.handler;

import com.qingmi.yi.common.utils.PrintJsonUtils;
import com.qingmi.yi.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
//@Component
public class AuthAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("======================认证异常================={}========",authException.getMessage());
        Throwable  causeThrowable = authException.getCause();
        if(causeThrowable instanceof InvalidTokenException){
            PrintJsonUtils.write(response, ResponseUtils.tokenExpire("令牌过期"));
        }else{
            PrintJsonUtils.write(response, ResponseUtils.loginFail("账号或密码错误"));
        }
    }
}
