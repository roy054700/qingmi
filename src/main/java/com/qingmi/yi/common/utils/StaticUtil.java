package com.qingmi.yi.common.utils;

/**
 * @Author: 李龙真
 * @Date: 2021/4/21 15:06
 */
public class StaticUtil {

    //中间部分替换为星号
    public static String replace(String parn){
        if(parn== null || parn.length()==0){
            return parn;
        }
         parn = parn.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
         return parn;
    }
}
