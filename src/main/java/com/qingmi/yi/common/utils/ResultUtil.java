package com.qingmi.yi.common.utils;

import com.qingmi.yi.common.vo.R;

public class ResultUtil<T> {

    private R<T> r;

    public ResultUtil(){
        r=new R<>();
        r.setMessage("success");
        r.setCode(200);
    }
    public R<T> setData(T t){
        this.r.setData(t);
        this.r.setCode(200);
        return this.r;
    }

    public R<T> setSuccessMsg(String msg){
        this.r.setMessage(msg);
        this.r.setCode(200);
        this.r.setData(null);
        return this.r;
    }

    public R<T> setData(T t, String msg){
        this.r.setData(t);
        this.r.setCode(200);
        this.r.setMessage(msg);
        return this.r;
    }

    public R<T> setErrorMsg(String msg){
        this.r.setMessage(msg);
        this.r.setCode(500);
        return this.r;
    }

    public R<T> setErrorMsg(Integer code, String msg){
        this.r.setMessage(msg);
        this.r.setCode(code);
        return this.r;
    }
}
