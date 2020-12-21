package com.qingmi.yi.common.handler;

import com.qingmi.yi.common.utils.PrintJsonUtils;
import com.qingmi.yi.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证没权限
 */
@Slf4j
//@Component
public class AuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("======================未授权================={}========",accessDeniedException.getMessage());
        PrintJsonUtils.write(response, ResponseUtils.unAuthorized("未授权"));
    }
}
