/*
 * For com.royal.art
 * Copyright [2015/11/23] By RICK
 */
package com.qingmi.yi.common.exception.msg;

/**
 * MobilePhoneErrorMsg
 * 手机号码异常消息
 * @author FCHEN
 * @date 2015/11/23
 */
public enum MobilePhoneErrorMsg {

    EMPTY_PHONE(1000,"手机号为空"),

    WRONG_PHONENUM(1001,"手机号码不正确"),

    PHONE_HAD_EXISTS(1002,"手机号码已存在"),

    PHONE_NOT_EXISTS(1003,"手机号码不存在"),

    ;


    private int code;
    private String msg;
    MobilePhoneErrorMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
