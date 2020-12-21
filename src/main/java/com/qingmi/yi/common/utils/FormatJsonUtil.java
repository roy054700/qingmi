package com.qingmi.yi.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FormatJsonUtil {

	/**
	 * 格式化
	 * @param jsonStr
	 * @return
	 * @author   cx
	 * @Date   2015-10-14 下午1:17:35
	 */
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    /**
          * 添加space
     * @param sb
     * @param indent
     * @author   cx
     * @Date   2015-10-14 上午10:38:04
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
    
    
    /**
     * Main函数
     * @param args
     */
    public static void main(String[] args) {
    	String json = "{\"code\":\"00\",\"message\":\"success\",\"data\":\"{\"rn\":null,\"userId\":778,\"employeeId\":819,\"phonePath\":\"G:\\\\zbtFile\\\\employeeImg\\\\步长制药\\\\事业一部\\\\口服药北区\\\\口服药山东大区\\\\济南N\\\\李道杰819\\\\头像20151211104609.JPG\",\"orgId\":1092,\"orgNm\":\"济南N\",\"orgcType\":6,\"employeeNm\":\"李道杰\",\"roleId\":null,\"roleName\":null,\"username\":\"李道杰\",\"pswd\":\"2ce50ac9e53ed76f820132c2ce6cd7ded2de72f082e0b384a803e389\",\"userType\":2,\"lastLoginTime\":1465403512000,\"lastLoginIp\":\"39.91.42.116\",\"thisLoginTime\":1465404127000,\"thisLoginIp\":\"39.91.42.116\",\"isEnabled\":1,\"creator\":null,\"creationTime\":1437566451000,\"modifier\":null,\"modifyTime\":null,\"isAllOcPro\":null,\"chineseCode\":null,\"loginType\":1,\"jobId\":null,\"jobNm\":null,\"roleNm\":null,\"sex\":null,\"isOrgHeader\":null,\"orgType\":null,\"parentOrgId\":null,\"parentOrgNm\":null,\"muchRole\":false,\"admin\":false}\"}";
    	json = formatJson(json);   
        System.err.println("json----->"+json);
	}
    
    /**
     * Gson格式化代码
     * @param uglyJSONString
     * @return
     */
    public static String jsonFormatter(String uglyJSONString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
	
}
