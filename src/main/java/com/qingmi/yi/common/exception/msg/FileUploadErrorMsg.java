/*
 * For com.royal.art
 * Copyright [2015/12/11] By FCHEN
 */
package com.qingmi.yi.common.exception.msg;

/**
 * FileUploadErrorMsg
 * 文件上传类异常
 * @author FCHEN
 * @date 2015/12/11
 */
public enum  FileUploadErrorMsg  {

    EMPTY_FILE(1300,"上传文件为空"),

    UNACCEPTED_FILE(1301,"不合格的文件类型"),

    NAME_FILE(1302,"上传文件名重复"),

    NAME_FOLDER(1303,"上传文件夹名称重复"),

    NAME_SECRECY(1304,"此文件是保密模式，无法操作"),

    ;


    private int code;
    private String msg;
    FileUploadErrorMsg(int code, String msg){
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
