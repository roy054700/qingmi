package com.qingmi.yi.common.handler;

import com.qingmi.yi.common.utils.PrintJsonUtils;
import com.qingmi.yi.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出
 */
@Slf4j
//@Component
public class AuthLogoutAuthenticationHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("=================================退出登录=========================");
        PrintJsonUtils.write(response, ResponseUtils.success("登出成功!"));
    }
}
