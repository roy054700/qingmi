package com.qingmi.yi.common.utils;

import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

public class BeanUtils extends BeanUtil {

    /**
     * 获取属性名数组
     * */
    public static String[] getFiledNames(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

}
