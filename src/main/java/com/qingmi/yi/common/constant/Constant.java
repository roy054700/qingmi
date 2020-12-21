package com.qingmi.yi.common.constant;

/**
 * @ClassNameConstant
 * @Description
 * @Author 冷言丶冷语
 * @Date2019-10-22 14:59
 **/
public interface Constant {
    /**
     * 短信appid
     */
    String SMS_ACCESSID="LTAIH1JvHmTJaTGN";
    /**
     * 应用秘钥
     */
    String SMS_SECRETKEY="UsKStbXdzf5Jbrmvez2IgBc1F7ylha";

    String SIGN_NAME="耕雨健康管家";

    String FORM_PLAT="阿里云";
    /**
     * 融云appKey
     */
    String RONG_YUN_APP_KEY="bmdehs6pbat8s";//开发环境
    /**
     * 融云SECRET
     */
    String RONG_YUN_APP_SECRET="fvFsZg4HOn";//开发环境


    /**
     * 微信认证接口
     */
    String WX_AUTH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";


    /**
     * 微信用户接口
     */
    String  WX_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 微信刷新token
     */
    String WX_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    /**
     * 微信授权地址
     */
    String WX_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /**
     * 微信公众号APP_ID 公众号的唯一标识
     */
    String WX_PUBLIC_APPID = "wx2a0bd65c780bc43c";

    /**
     * 微信公众号 公众号的appsecret
     */
    String WX_PUBLIC_APP_SECRET = "5fe27149890b0583fd86308ef4a63b8c";
}
