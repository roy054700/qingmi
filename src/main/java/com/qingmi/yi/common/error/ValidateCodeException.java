package com.qingmi.yi.common.error;

import org.springframework.security.core.AuthenticationException;

/**
 * @author chengxin
 * @description
 * @date 2019/12/1
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super("校验失败");
    }
}
