package com.qingmi.yi.common.constant;

/**
 * 用户Header 头部Token
 * @author chengxin
 */
public final class ConstantToken {

    /**
     * Token Authorization
     */
    public final static String AUTHORIZATION_KEY = "Authorization";

    /**
     *Token Token
     */
    public final static String TOKEN_KEY = "access_token";

    /**
     * JWT加密密钥
     */
    public final static  String JWT_SECRET = "GyJK";

    /**
     * jwt中 userId的key
     */
    public final static String USER_ID = "userId";

    /**
     * jwt中 clientId的key
     */
    public final static String CLIENT_ID = "client_id";

    /**
     * jwt中clientSecret
     */
    public final static String CLIENT_SECRET="client_secret";

    /**
     * 客户端类型
     */
    public final static String CLIENT_TYPE = "clientType";

    /**
     * 用户名称
     */
    public final static String USER_NAME = "userName";


    /**
     * 登录类型
     */
    public final static String LOGIN_TYPE = "loginType";

    /**
     * 微信登录手机号码
     */
    public final static String LOGIN_MOBILE = "mobile";

    /**
     * openid
     */
    public final static String LOGIN_OPENID = "openid";

    /**
     * 用户类型
     */
    public final static String USER_TYPE = "userType";

    /**
     * 授权类型
     */
    public final static String GRANT_TYPE="grant_type";


    /**
     * oauth token
     */
    public final static  String LOGIN = "/oauth/login";

    /**
     * oauth logut
     */
    public final static String LOGOUT = "/oauth/logout";

    /**
     * 手机登录URL
     */
    public final static  String MOBILE_TOKEN_URL = "/oauth/mobile";
    /**
     * 微信登陆URL
     */
    public final static  String WECHAT_TOKEN_URL = "/oauth/openLogin";

    /**
     * redis token 前缀
     */
    public final static String REDIS_TOKEN_PREFIX = "gyjk";

    /**
     * jwt中 角色集合的key
     */
    public final static String AUTHORITIES = "authorities";

    /**
     * jwt中 jti
     */
     public final static String JTI = "jti";

    /**
     * 是否绑定
     */
    public final static String  IS_BIND__MOBILE= "bind_mobile";

    /**
     * token 过期时间
     * token有效期自定义设置，默认12小时
     */
    public final static int ACCESS_TOKEN_VALIDITY_SECONDS = 60*60*12;

    /**
     * refresh_token 过期时间
     * refresh_token默认30天
     */
    public final static int REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 7;


    public final static String SMS_CODE_KEY = "smsCode";
    public final static String SMS_IMAGE_CODE_KEY ="captcha";
    public final static String SMS_BIND_WX_CODE ="smsBindWxCode";
    public final static String SMS_UPDATE_PHONE ="smsUpdatePhone";
    public final static String SMS_MODIFY_PASSWORD = "modifyCode";

    /**
     * 管理员默认id
     */
    public final static String  PC_ADMIN_ID = "99999";
    public final static String  PHONE_ADMIN_ID = "88888";

    public final static String PC_ADMIN_PASSWORD = "GengYu120!@#";

    public final static String OPEN_CODE = "openCode";
    public final static String OPEN_ID = "openId";
}
