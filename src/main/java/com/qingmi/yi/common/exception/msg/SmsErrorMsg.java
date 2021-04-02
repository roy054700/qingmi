/*
 * For com.royal.art
 * Copyright [2015/11/23] By FCHEN
 */
package com.qingmi.yi.common.exception.msg;

/**
 * SmsErrorMsg
 * 短信类错误码
 * @author FCHEN
 * @date 2015/11/23
 */
public enum SmsErrorMsg {

    SMS_NOT_EXISTS(1100,"验证码无效"),

    SMS_OVERDUE(1101,"验证码已失效"),

    SMS_SEND_FAILED(1102,"短信发送失败"),

    SMS_IS_VALID(1102,"短信已校验"),

    ;


    private int code;
    private String msg;
    SmsErrorMsg(int code, String msg){
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
