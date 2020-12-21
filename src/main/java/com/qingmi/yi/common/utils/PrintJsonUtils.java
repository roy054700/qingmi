package com.qingmi.yi.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 打印json
 */
@Slf4j
public class PrintJsonUtils {

    public static void write(HttpServletResponse response, Object data){
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-store");
        try{
            PrintWriter writer = response.getWriter();
            writer.write(GsonUtils.getInstance().gsonString(data));
            writer.flush();
        }catch (Exception ex){
           ex.printStackTrace();
        }
    }
}
