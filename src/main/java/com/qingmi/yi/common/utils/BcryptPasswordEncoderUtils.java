package com.qingmi.yi.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /**
     *  将原生密码进行加密
     * @return 加密后的字符串密码
     */
    public static String encode(String rawPWD){
        String hashedPassword = passwordEncoder.encode(rawPWD);
        return hashedPassword;
    }

    /**
     * 比较原生密码与密文是否一致
     * @param rawPWD 原生密码
     * @param encodePWD 密文
     * @return true/false
     */
    public static boolean matches(String rawPWD,String encodePWD){
        boolean result = passwordEncoder.matches(rawPWD, encodePWD);
        return result;
    }

    public static void main(String[] args) {

        System.out.print("" + encode("GengYu120!@#"));
    }
}
