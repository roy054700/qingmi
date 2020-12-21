package com.qingmi.yi.common.utils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * 生成令牌工具类
 * @author chengxin
 */
public class TokenUtils {

	    public static final String numberChar = "0123456789";
		
		/**      
		 * 根据系统时间获得指定位数的随机数      
		 * @return 获得的随机数
		 **/    
		public static String getRandom() {
			Long seed = System.currentTimeMillis();	// 获得系统时间，作为生成随机数的种子
			StringBuffer sb = new StringBuffer();	// 装载生成的随机数
			Random random = new Random(seed);		// 调用种子生成随机数 
			for (int i = 0; i < 20; i++) {
				sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
			}
			return sb.toString();
		}
		
		/**
		 * @param s
		 * @return
		 */
		 public static  String MD5(String s) {
		        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

		        try {
		            byte[] btInput = s.getBytes();
		            // 获得MD5摘要算法的 MessageDigest 对象
		            MessageDigest mdInst = MessageDigest.getInstance("MD5");
		            // 使用指定的字节更新摘要
		            mdInst.update(btInput);
		            // 获得密文
		            byte[] md = mdInst.digest();
		            // 把密文转换成十六进制的字符串形式
		            int j = md.length;
		            char str[] = new char[j * 2];
		            int k = 0;
		            for (int i = 0; i < j; i++) {
		                byte byte0 = md[i];
		                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
		                str[k++] = hexDigits[byte0 & 0xf];
		            }
		            return new String(str);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		}
		 
	 /**
	  * 生成token
	  * @return
	  */
	   public static  String makeToken() {
		   return MD5(getRandom());
	   }
	   
	   public static void main(String[] args) {
		    System.out.println(makeToken());
	   }
}
