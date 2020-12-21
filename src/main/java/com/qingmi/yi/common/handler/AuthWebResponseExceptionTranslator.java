package com.qingmi.yi.common.handler;

import com.qingmi.yi.common.error.CustomOauth2Exception;
import com.qingmi.yi.common.enums.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class AuthWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e){
        log.info("===================认证异常================{}=====",e.getMessage());
        if (e instanceof InvalidGrantException) {
            return ResponseEntity
                    .status(ResponseEnum.LOGIN_FAIL.getCode())
                    .body(new CustomOauth2Exception("用户名或密码错误!"));
        }else if(e instanceof InvalidTokenException){
            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new CustomOauth2Exception("令牌过期!"));
        } else if(e instanceof UsernameNotFoundException || e instanceof BadCredentialsException){
            return ResponseEntity
                    .status(ResponseEnum.LOGIN_FAIL.getCode())
                    .body(new CustomOauth2Exception("用户名或密码错误!"));
        }else if(e instanceof InternalAuthenticationServiceException){
            return ResponseEntity
                    .status(ResponseEnum.LOGIN_FAIL.getCode())
                    .body(new CustomOauth2Exception("用户名或密码错误!"));
        }else{
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new CustomOauth2Exception("其他异常错误，请稍后再试！"));
        }
    }
}
