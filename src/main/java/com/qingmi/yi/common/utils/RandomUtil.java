package com.qingmi.yi.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @ClassNameRandomUtil
 * @Description
 * @Author 冷言丶冷语
 * @Date2019-9-17 11:06
 **/
public class RandomUtil {
    /**
     * 产生指定位数的随机数
     * @param length
     * @return
     */
    public static String getRandomNumber(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    public static String getNo(String prefix){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.now();
        return prefix+dateTime.format(dateTimeFormatter)+getRandomNumber(4);
    }

}
