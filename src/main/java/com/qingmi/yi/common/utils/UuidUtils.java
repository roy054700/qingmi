package com.qingmi.yi.common.utils;

import java.util.UUID;

public class UuidUtils {
    public static String randomUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
