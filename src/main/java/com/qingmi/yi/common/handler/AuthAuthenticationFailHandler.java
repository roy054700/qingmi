package com.qingmi.yi.common.handler;

import com.qingmi.yi.common.utils.PrintJsonUtils;
import com.qingmi.yi.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败
 */
@Slf4j
//@Component
public class AuthAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
      log.info("=========================================登录失败============================================");
        PrintJsonUtils.write(response, ResponseUtils.loginFail("用户名密码错误!"));
    }
}
