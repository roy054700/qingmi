package com.qingmi.yi.common.exception;

import com.qingmi.yi.common.enums.ResultCode;

/**
 * 基础异常类
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code = ResultCode.FAIL.code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
