package com.qingmi.yi.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝API工具类
 */
public class AliUtil {

	public static String ali_public_key  = "支付宝公钥";
	/**
	 * 返回数据封装Map
	 * @param map
	 * @return
	 */
	public static Map<String,String> getReturnParams(Map map){
		Map<String,String> params = new HashMap<>();
		for(Iterator it = map.keySet().iterator(); it.hasNext();){
			String name = (String)it.next();
			String[] values = (String[]) map.get(name);
			String valueStr= "";
			for(int i=0;i < values.length;i++){
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				//存在乱码可能性，解决乱码
				//valueStr = toUTF8(valueStr);
				params.put(name, valueStr);
			}
		}
		return params;
	}

	/**
	 * 将中文汉字转成UTF8编码
	 *
	 * @param str
	 * @return
	 */
	public static String toUTF8(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		try {
			return new String(str.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}


	public static void main(String[] args) {
		System.out.println("支付宝支付相关工具类");
	}
}
