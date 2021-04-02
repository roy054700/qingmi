/*
 * For com.royal.art
 * Copyright [2015/11/17] By FCHEN
 */
package com.qingmi.yi.common.exception;

/**
 * AbstractException
 * 全局异常
 * @author FCHEN
 * @date 2015/11/17
 */
public class AbstractException extends RuntimeException {

    private static final long serialVersionUID = -4894165230402977392L;

    protected int code;
    protected String msg;
    //真实的异常抛出
    protected Throwable realThrowble;

    public AbstractException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return "code="+this.code + ";msg="+this.msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Throwable getRealThrowble() {
        return realThrowble;
    }

    public void setRealThrowble(Throwable realThrowble) {
        this.realThrowble = realThrowble;
    }
}
