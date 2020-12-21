package com.qingmi.yi.common.enums;

/**
 * 响应码枚举
 * @author Administrator
 */
public enum ResultCode {
    //成功响应
    SUCCESS("成功", 200),
    //失败响应
    FAIL("失败", 400),
    //未登录
    LOGIN_FAIL("未登录", 401),
    //未授权
    UNAUTHORIZED("未授权", 403),
    //不存在
    NOT_FOUND("不存在", 404),
    //服务器错误
    INTERNAL_SERVER_ERROR("服务器异常，请联系管理员", 500),
    //网络连接失败
    NET_CONNECTION_FAIL("调用失败，请检查你的网络连接",302);
    public int code;

    public String name;

    ResultCode(String name, int code) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

