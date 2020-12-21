package com.qingmi.yi.common.constant;

/**
 * 公共常量类
 */
public final class CommonConstant {
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    /**
     * 商户二维码唯一标识
     */
    public static final String bundleId = "gyjkmerchant123!@#";
    /**
     * 体检订单编码前缀
     */
    public static final String ORDER_NO_MEDICAL_PREFIX = "T";

    /**
     * 商品订单编码前缀
     */
    public static final String ORDER_NO_GOODS_PREFIX = "S";

    /**
     * 商品退货单编码前缀
     */
    public static final String RETURNS_ORDER_NO_GOODS_PREFIX = "R";

    /**
     * 充值订单编码前缀
     */
    public static final String RECHARGE_NO_PREFIX = "CZ";

    /**
     * 体检套餐编码前缀
     */
    public static final String PLAN_NO_MEDICAL_PREFIX = "TC";

    /**
     * 体检报告前缀
     */
    public static final String REPORT_CODE_MEDICAL_PREFIX = "B";
    /**
     * 健康档案前缀
     */
    public static final String ARCHIVE_NO_MEDICAL_PREFIX = "J";

    /**
     * 定制订单前缀
     */
    public static final String COMMUNICATION_RECORDS_CODE_PREFIX = "DZ";
    /**
     * 预约订单编码前缀
     */
    public static final String RESERVATION_ORDER_NO_PREFIX = "Y";
    /**
     * 健康任务编码前缀
     */
    public static final String HEALTH_TASK_NO_PREFIX = "HT";
    /**
     * 商户扫码支付编码前缀
     */
    public static final String MERCHANT_NO_PREFIX = "SH";
    /**
     * 服务包编码
     */
    public static final String SERVICE_PACKAGE_NO = "F";
    /**
     * 标准资费默认单位
     */
    public static final String TARIFF_UNIT_MONTH = "月";


    /**
     * 健康币
     */
    public static final Integer IS_COUPON = 1;
    public static final Integer IS_NO_COUPON = 2;

    /**
     * 执行操作
     */
    public static final Integer OPER_SUCCESS = 1;
    public static final Integer OPER_FAIL = 0;


    /**
     * 客户端id
     */
    public static final String CLIENT_PHONE = "phone";
    public static final String ClENT_PC = "pc";

    /**
     * 服务包缴费1未支付2支付
     */
    public static final Integer RENEW_UN_PAY = 1;
    public static final Integer RENEW_HAS_PAY = 2;


    /**
     * 服务包缴费1是 2否
     */
    public static final Integer IS_TRIM_YES = 1;
    public static final Integer IS_TRIM_NO = 2;

    /**
     * 预约日志场景
     */
    public static final String SP_APPOINTMENT_LOG_1 = "用户提交预约信息";
    public static final String SP_APPOINTMENT_LOG_2 = "用户自行取消预约";
    public static final String SP_APPOINTMENT_LOG_3 = "用户提交预约信息";
    public static final String SP_APPOINTMENT_LOG_4 = "平台工作人员协助取消预约";
    public static final String SP_APPOINTMENT_LOG_5 = "平台工作人员协助调整预约信息";
    public static final String SP_APPOINTMENT_LOG_6 = "平台工作人员确认预约信息";

    /**
     * 快递100key
     */
    public static final String KUAIDI_KEY = "PAiwAGTY952";
    /**
     * 查询公司编号
     */
    public static final String CUSTOMERCODE = "7D1AFCCB5E96CD475D2CDA04692AF8B8";

    /**
     * 用户默认信息
     */
    public static final String USER_APP_PICTURE = "http://121.40.96.164:8989/static/defaultUser/defaultUser.jpg";
    public static final String USER_APP_LICKNAME = "耕雨管家";
    public static final String USER_APP_DEFAULT_PWD = "GYJKGJ!@#456";
    /**
     * 线下服务场景标识
     */
    public static final Integer SERVICE_SCENE_FLAG_XX = -1;

    /**
     * 基因肿瘤订单受理标识 -- 已受理
     */
    public static final Integer GENE_ORDER_Y = 2;
    /**
     * 基因肿瘤订单受理标识 -- 未受理
     */
//    public static final Integer GENE_ORDER_N = 1;

    /**
     * 主订单支付
     */
    public static final Integer IS_MAIN_PAY_Y = 1;
    /**
     * 子订单支付
     */
    public static final Integer IS_MAIN_PAY_N = 2;

    /**
     * 融云发送系统消息时的sendUserId
     */
    public static final String RONG_CLOUD_SYS_SEND_USER_ID = "11111";

    /**
     * 融云发送系统消息时的sendUserName
     */
    public static final String RONG_CLOUD_SYS_SEND_USER_NAME = "耕雨健康管家";

    /**
     * 融云发送系统消息时的sendUserPortrait
     */
    public static final String RONG_CLOUD_SYS_SEND_USER_PORTRAIT = "http://www.rongcloud.cn/images/logo.png";

    /**
     * 消息场景编码-提交预约信息
     */
    public static final String MESSAGE_SCENE_CODE_RESERVATION = "GY_NEWS_001";

    /**
     * 消息场景编码-平台管理员确认预约订单
     */
    public static final String MESSAGE_SCENE_CODE_CONFIRM_RESERVATION = "GY_NEWS_002";

    /**
     * 消息场景编码-平台管理员调整预约订单
     */
    public static final String MESSAGE_SCENE_CODE_ADJUSTMENT_RESERVATION = "GY_NEWS_003";

    /**
     * 消息场景编码-检前通知
     */
    public static final String MESSAGE_SCENE_CODE_BEFORE_INSPECTION_ADVICE = "GY_NEWS_004";

    /**
     * 消息场景编码-平台管理员完成订单
     */
    public static final String MESSAGE_SCENE_CODE_COMPLETE_RESERVATION = "GY_NEWS_005";

    /**
     * 消息场景编码-上传完体检报告
     */
    public static final String MESSAGE_SCENE_CODE_REPORT_RELEASE = "GY_NEWS_006";

    /**
     * 消息场景编码-平台管理员填写发货信息
     */
    public static final String MESSAGE_SCENE_CODE_SHIP = "GY_NEWS_007";

    /**
     * 消息场景编码-充值卡绑卡成功
     */
    public static final String MESSAGE_SCENE_CODE_BIND_CARD = "GY_NEWS_008";

    /**
     * 消息场景编码-非充值卡绑卡成功时
     */
    public static final String MESSAGE_SCENE_CODE_RECHARGE_BIND_CARD = "GY_NEWS_009";

    /**
     * 消息场景编码-成功邀请好友
     */
    public static final String MESSAGE_SCENE_CODE_INVITE_FRIENDS = "GY_NEWS_010";

    /**
     * 消息场景编码-申请通知
     */
    public static final String MESSAGE_SCENE_CODE_ARCHIVES_APPLICATION = "GY_NEWS_011";

    /**
     * 消息场景编码-同意申请
     */
    public static final String MESSAGE_SCENE_CODE_AGREE_ARCHIVES_APPLICATION = "GY_NEWS_012";
}
