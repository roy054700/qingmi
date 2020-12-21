package com.qingmi.yi.common.enums;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * 字典枚举表
 *
 * @author chengxin
 */
public enum SysDictEnum {

    LOGIN_TYPE_WX("登录类型", "微信", "LOGIN_TYPE", 3),
    LOGIN_TYPE_PHONE("登录类型", "手机号", "LOGIN_TYPE", 2),
    LOGIN_TYPE_PWD("登录类型", "密码", "LOGIN_TYPE", 1),

    DATA_STATUS_ENABLE("数据状态", "正常", "DATA_STATUS", 1),
    DATA_STATUS_DISABLE("数据状态", "删除", "DATA_STATUS", 2),

    MENU_TYPE_MENU("菜单类型", "菜单", "MENU_TYPE", 1),
    MENU_TYPE_BUTTON("菜单类型", "按钮", "MENU_TYPE", 2),

    USER_TYPE_APP("用户类型", "APP用户", "USER_TYPE", 1),
    USER_TYPE_WEB("用户类型", "WEB管理员", "USER_TYPE", 2),
    USER_TYPE_MANAGER("用户类型", "系统管理员", "USER_TYPE", 3),

    USER_SEX_MAN("性别", "男", "SEX", 1),
    USER_SEX_WOMAN("性别", "女", "SEX", 2),

    OPERATIONAL_NATURE_LIMITED("经营性质", "民营企业", "OPER_NATURE", 1),
    OPERATIONAL_NATURE_GOVERNMENT("经营性质", "政府机关", "OPER_NATURE", 2),
    OPERATIONAL_NATURE_INSTITUTION("经营性质", "事业单位", "OPER_NATURE", 3),
    OPERATIONAL_NATURE_SOCIALORGINIZATION("经营性质", "社会组织", "OPER_NATURE", 4),

    CUSTOMER_LEVEL_A("客户等级", "A", "CUSTOMER_LEVEL", 1),
    CUSTOMER_LEVEL_B("客户等级", "B", "CUSTOMER_LEVEL", 2),
    CUSTOMER_LEVEL_C("客户等级", "C", "CUSTOMER_LEVEL", 3),

    BLOOD_TYPE_A("血型", "A型", "BLOOD_TYPE", 1),
    BLOOD_TYPE_B("血型", "B型", "BLOOD_TYPE", 2),
    BLOOD_TYPE_AB("血型", "AB型", "BLOOD_TYPE", 3),
    BLOOD_TYPE_O("血型", "O型", "BLOOD_TYPE", 4),


    COMPANY("职业", "政府企业事业单位", "OCCUPATION", 1),
    PRIVATE_EMPLOYEES("职业", "私企员工", "OCCUPATION", 2),
    ARTISAN("职业", "专业技术人员", "OCCUPATION", 3),
    BUSINESS("职业", "商业、服务业人员", "OCCUPATION", 4),
    OTHER_WORK("职业", "其他", "OCCUPATION", 5),


    PRIMARY_SCHOOL ("学历", "小学", "EDUCATION", 1),
    JUNIOR_MIDDLE_SCHOOL("学历", "初中", "EDUCATION", 2),
    HIGH_SCHOOL("学历", "高中", "EDUCATION", 3),
    SPECIALTY("学历", "专科", "EDUCATION", 4),
    UNDERGRADUATE("学历", "本科", "EDUCATION", 5),
    GRADUATE_STUDENT("学历", "研究生", "EDUCATION", 6),
    MASTER("学历", "硕士", "EDUCATION", 7),
    DOCTOR("学历", "博士", "EDUCATION", 8),
    POST_DOCTORAL("学历", "博士后", "EDUCATION", 9),

    /**
     * 卡类型
     */
    CARD_TYPE_TEAM("卡类型", "团体卡", "CARD_TYPE", 1),
    CARD_TYPE_COMMON("卡类型", "公益卡", "CARD_TYPE", 2),
    CARD_TYPE_CHANNEL("卡类型", "渠道卡", "CARD_TYPE", 3),
    CARD_TYPE_VIP("卡类型", "贵宾卡", "CARD_TYPE", 4),

    /**
     * 卡状态 待制卡/待确认/待销售/待激活/待使用/已使用/已过期/已作废/已冻结
     */
    CARD_INSTANCE_WAIT_MAKE("卡实例状态", "待制卡", "CARD_INSTANCE_STATE", 1),
    CARD_INSTANCE_WAIT_CONFIRM("卡实例状态", "待确认", "CARD_INSTANCE_STATE", 2),
    CARD_INSTANCE_WAIT_SALE("卡实例状态", "待销售", "CARD_INSTANCE_STATE", 3),
    CARD_INSTANCE_WAIT_ACTIVE("卡实例状态", "待激活", "CARD_INSTANCE_STATE", 4),
    CARD_INSTANCE_WAIT_USE("卡实例状态", "待使用", "CARD_INSTANCE_STATE", 5),
    CARD_INSTANCE_HAS_USE("卡实例状态", "已使用", "CARD_INSTANCE_STATE", 6),
    CARD_INSTANCE_HAS_EXPIRE("卡实例状态", "已过期", "CARD_INSTANCE_STATE", 7),
    CARD_INSTANCE_HAS_INVALID("卡实例状态", "已作废", "CARD_INSTANCE_STATE", -1),
    CARD_INSTANCE_HAS_FREEZE("卡实例状态", "已冻结", "CARD_INSTANCE_STATE", 0),
    /**
     * 机构等级
     */
    ORGAN_LEVEL_THREE_T("机构等级", "三级特等", "ORGAN_LEVEL", 1),
    ORGAN_LEVEL_THREE_J("机构等级", "三级甲等", "ORGAN_LEVEL", 2),
    ORGAN_LEVEL_THREE_Y("机构等级", "三级乙等", "ORGAN_LEVEL", 3),
    ORGAN_LEVEL_THREE_B("机构等级", "三级丙等", "ORGAN_LEVEL", 4),
    ORGAN_LEVEL_TWO_J("机构等级", "二级甲等", "ORGAN_LEVEL", 5),
    ORGAN_LEVEL_TWO_Y("机构等级", "二级乙等", "ORGAN_LEVEL", 6),
    ORGAN_LEVEL_TWO_B("机构等级", "二级丙等", "ORGAN_LEVEL", 7),
    ORGAN_LEVEL_ONE("机构等级", "一级", "ORGAN_LEVEL", 8),

    /**
     * 体检订单状态
     */
    MEDICAL_ORDER_HAS_CANCEL("体检订单状态", "已取消", "ORDER_STATE", -1),
    MEDICAL_ORDER_WAIT_PAY("体检订单状态", "待付款", "ORDER_STATE", 0),
    MEDICAL_ORDER_WAIT_APPOINT("体检订单状态", "待预约", "ORDER_STATE", 1),
    MEDICAL_ORDER_WAIT_SERVER("体检订单状态", "待体检", "ORDER_STATE", 2),
    MEDICAL_ORDER_WAIT_COMMENT("体检订单状态", "待评价", "ORDER_STATE", 3),
    MEDICAL_ORDER_HAS_FINISH("体检订单状态", "已完成", "ORDER_STATE", 4),
    MEDICAL_ORDER_HAS_INVALID("体检订单状态", "已作废", "ORDER_STATE", -2),
    /**
     * 体检订单类型
     */
    MEDICAL_ORDER_C_TYPE("订单类型", "C端订单", "ORDER_TYPE", 1),
    MEDICAL_ORDER_GROUP_TYPE("订单类型", "团检订单", "ORDER_TYPE", 2),
    MEDICAL_ORDER_DIY_TYPE("订单类型", "DIY订单", "ORDER_TYPE", 3),
    MEDICAL_ORDER_ONETOONE_TYPE("订单类型", "OneToOne订单", "ORDER_TYPE", 4),

    /**
     * 支付类型
     */
    ORDER_WX_PAY("支付类型", "微信支付", "PAY_TYPE", 1),
    ORDER_Ali_PAY("支付类型", "支付宝支付", "PAY_TYPE", 2),
    ORDER_BALANCE_PAY("支付类型", "余额支付", "PAY_TYPE", 3),

    /**
     * 支付场景类型
     */
    WX_PAY("支付场景类型", "微信移动支付", "PAY_CONFIG", 1),
    WX_PAY_PROGRAM("支付场景类型", "微信小程序支付", "PAY_CONFIG", 2),
    ALI_PAY("支付场景类型", "支付宝支付", "PAY_CONFIG", 3),
    WX_PUBLIC_PAY("支付场景类型", "微信公众号支付", "PAY_CONFIG", 4),
    /**
     * 企业类型
     */
    ENTERPRISE_TYPE_MEDICAL_INSTITUTION("企业类型", "体检机构", "ENTERPRISE_TYPE", 1),
    ENTERPRISE_TYPE_HOSPITAL_INSTITUTION("企业类型", "医疗机构", "ENTERPRISE_TYPE", 2),
    ENTERPRISE_TYPE_OTHER_INSTITUTION("企业类型", "其他", "ENTERPRISE_TYPE", 3),

    /**
     * 企业状态
     */
    ENTERPRISE_STATE_VALID("企业状态", "有效", "ENTERPRISE_STATE", 1),
    ENTERPRISE_STATE_EXPIRE("企业状态", "无效", "ENTERPRISE_STATE", 2),

    /**
     * 门店状态
     */
    STORE_STATE_VALID("门店状态", "有效", "STORE_STATE", 1),
    STORE_STATE_EXPIRE("门店状态", "无效", "STORE_STATE", 2),

    /**
     * 楼层状态
     */
    FLOOR_MANAGER_STATE_VALID("楼层状态", "有效", "FLOOR_MANAGER_STATE", 1),
    FLOOR_MANAGER_STATE_EXPIRE("楼层状态", "无效", "FLOOR_MANAGER_STATE", 2),
    /**
     * 品牌状态
     */
    BRAND_STATE_VALID("品牌状态", "有效", "BRAND_STATE", 1),
    BRAND_STATE_EXPIRE("品牌状态", "无效", "BRAND_STATE", 2),

    /**
     * 套餐状态
     */
    MEDICAL_PLAN_STATE_VALID("套餐状态", "有效", "MEDICAL_PLAN_STATE", 1),
    MEDICAL_PLAN_STATE_EXPIRE("套餐状态", "无效", "MEDICAL_PLAN_STATE", 2),
    MEDICAL_PLAN_STATE_SALE("套餐状态", "在售", "MEDICAL_PLAN_STATE", 3),
    MEDICAL_PLAN_STATE_AUDIT("套餐状态", "待审核", "MEDICAL_PLAN_STATE", 4),
    MEDICAL_PLAN_STATE_PERFECTED("套餐状态", "待完善", "MEDICAL_PLAN_STATE", 5),


    /**
     * 定制订单状态
     */
    CUSTOM_ORDER_STATE_DGT("定制订单状态", "待沟通", "CUSTOM_ORDER_STATE", 1),
    CUSTOM_ORDER_STATE_DDZ("定制订单状态", "待定制", "CUSTOM_ORDER_STATE", 2),
    CUSTOM_ORDER_STATE_COMPLETE("定制订单状态", "已完成", "CUSTOM_ORDER_STATE", 3),
    CUSTOM_ORDER_STATE_CANCEL("定制订单状态", "已取消", "CUSTOM_ORDER_STATE", 4),
    CUSTOM_ORDER_STATE_EXPIRE("定制订单状态", "已失效", "CUSTOM_ORDER_STATE", 5),

    /**
     * 优惠券使用状态
     */
    COUPON_STATE_NO_USE("优惠券使用状态", "未使用", "COUPON_STATE", 1),
    COUPON_STATE_USE("优惠券使用状态", "已使用", "COUPON_STATE", 2),
    COUPON_STATE_EXPIRE("优惠券使用状态", "已过期", "COUPON_STATE", 3),

    /**
     * 优惠券状态
     */
    YH_COUPON_STATE_YES("优惠券状态", "有效", "YH_COUPON_STATE", 1),
    YH_COUPON_STATE_NO("优惠券状态", "无效", "YH_COUPON_STATE", 2),


    /**
     * 兑换券状态
     */
    DH_COUPON_STATE_YES("兑换券状态", "有效", "DH_COUPON_STATE", 1),
    DH_COUPON_STATE_NO("兑换券状态", "无效", "DH_COUPON_STATE", 2),


    /**
     * 优惠券类型
     */
    REDUCE_COUPON("优惠券类型", "满减券", "COUPON_TYPE", 1),
    DISCOUNT_COUPON("优惠券类型", "折扣卷", "COUPON_TYPE", 2),

    /**
     * 优惠券使用场景 value是sp_platform_coupon_use_scenes表主键id
     */
    COUPON_USE_SCENES_NEWCOMER("优惠券使用场景", "新人专享", "COUPON_USE_SCENES", 1),
    COUPON_USE_SCENES_UNIVERSAL("优惠券使用场景", "全平台通用", "COUPON_USE_SCENES", 2),
    COUPON_USE_SCENES_GENE("优惠券使用场景", "基因优惠券", "COUPON_USE_SCENES", 3),
    COUPON_USE_SCENES_TUMOR("优惠券使用场景", "肿瘤优惠券", "COUPON_USE_SCENES", 4),
    COUPON_USE_SCENES_PLAN("优惠券使用场景", "体检套餐", "COUPON_USE_SCENES", 5),
    COUPON_USE_SCENES_MALL("优惠券使用场景", "商城", "COUPON_USE_SCENES", 6),


    /**
     * diy定制标签状态
     */
    DIY_SHOW("diy定制标签", "显示", "DIY_LABEL_STATE", 1),
    DIY_HIDDEN("diy定制标签", "隐藏", "DIY_LABEL_STATE", 2),


    /**
     * 优惠券有效期类型
     */
    COUPON_YEAR("优惠券有效期类型", "年", "COUPON_VALID_TYPE", 1),
    COUPON_MONTH("优惠券有效期类型", "月", "COUPON_VALID_TYPE", 2),
    COUPON_DAY("优惠券有效期类型", "日", "COUPON_VALID_TYPE", 3),

    /**
     * 订单预约状态
     */
    ORDER_APPOINTMENT_RESERVATION("订单预约状态", "已预约", "ORDER_APPOINTMENT", 1),
    ORDER_APPOINTMENT_NO_RESERVATION("订单预约状态", "已取消", "ORDER_APPOINTMENT", 2),


    ORDER_CONFIRM_APPOINTMENT("订单待确认状态","已确认","ORDER_CONFIRM_APPOINTMENT",1),
    ORDER_NO_CONFIRM_APPOINTMENT("订单待确认状态","未确认","ORDER_CONFIRM_APPOINTMENT",2),
    /**
     * 体检报告状态
     */
    MEDICAL_REPORT_TO_BE_PERFECTED("体检报告状态", "待完善", "MEDICAL_REPORT", 1),
    MEDICAL_REPORT_TO_BE_SOLVED("体检报告状态", "待解决", "MEDICAL_REPORT", 2),
    MEDICAL_REPORT_PENDING_RELEASE("体检报告状态", "待发布", "MEDICAL_REPORT", 3),
    MEDICAL_REPORT_SHELF("体检报告状态", "已上架", "MEDICAL_REPORT", 4),

    /**
     * 婚姻状态
     */
    MARRIED("婚姻状态", "已婚", "MARITAL_STATUS", 1),
    UNMARRIED("婚姻状态", "未婚", "MARITAL_STATUS", 2),

    /**
     * 用户激活状态
     */
    USER_ACTIVE_STATE("用户状态","激活","USER_ACTIVE_STATE",1),
    USER_ACTIVE__UN_STATE("用户状态","未激活","USER_ACTIVE_STATE",2),
    /*
     * 问卷类型
     */
    HEALTHY("问卷类型", "健康档案", "QUESTION_TYPE", 1),


    /**
     * 文件类型
     */
    TEXT("文件类型", "Text", "FILE_TYPE", 1),
    EXCEL("文件类型", "Excel", "FILE_TYPE", 2),
    WORD("文件类型", "Word", "FILE_TYPE", 3),
    PDF("文件类型", "PDF", "FILE_TYPE", 4),
    ZIP("文件类型", "ZIP", "FILE_TYPE", 5),
    IMAGE("文件类型", "IMAGE", "FILE_TYPE", 6),
    VIDEO("文件类型", "VIDEO", "FILE_TYPE", 7),

    /**
     * 轮播图类型
     */
    BANNER_IMAGE("轮播图类型", "图片", "BANNER_TYPE", 1),
    BANNER_VIDEO("轮播图类型", "视频", "BANNER_TYPE", 2),

    /**
     * 轮播图链接类型
     */
    BANNER_LINK_INSIDE("轮播图链接类型", "内部", "BANNER_LINK_TYPE", 1),
    BANNER_LINK_EXTERNAL("轮播图链接类型", "外部", "BANNER_LINK_TYPE", 2),

    /**
     * 轮播图状态
     */
    BANNER_ENABLE("轮播图状态", "启用", "BANNER_STATE", 1),
    BANNER_DISABLE("轮播图状态", "禁用", "BANNER_STATE", 2),

    /**
     * 是否自动播放
     */
    IS_AUTO_PLAY_YES("是否自动播放", "是", "IS_AUTO_PLAY", 1),
    IS_AUTO_PLAY_NO("是否自动播放", "否", "IS_AUTO_PLAY", 2),

    /**
     * 客户单位类别
     */
    CUSTOMER_TYPE_ADMINISTRATIVE("客户单位类别", "行政单位", "CUSTOMER_TYPE", 1),
    CUSTOMER_TYPE_CAUSE("客户单位类别", "事业单位", "CUSTOMER_TYPE", 2),
    CUSTOMER_TYPE_NATIONALIZED("客户单位类别", "国有企业", "CUSTOMER_TYPE", 3),
    CUSTOMER_TYPE_PRIVATE("客户单位类别", "私营企业", "CUSTOMER_TYPE", 4),
    CUSTOMER_TYPE_SOCIETY("客户单位类别", "社会组织", "CUSTOMER_TYPE", 5),
    CUSTOMER_TYPE_OTHER("客户单位类别", "其他", "CUSTOMER_TYPE", 6),

    /**
     * 客户所属行业
     */
    CUSTOMER_INDUSTRY_FINANCIAL("客户所属行业", "金融", "CUSTOMER_INDUSTRY", 1),
    CUSTOMER_INDUSTRY_TELECOMMUNICATIONS("客户所属行业", "电信", "CUSTOMER_INDUSTRY", 2),
    CUSTOMER_INDUSTRY_EDUCATION("客户所属行业", "教育", "CUSTOMER_INDUSTRY", 3),
    CUSTOMER_INDUSTRY_HIGH_TECH("客户所属行业", "高科技", "CUSTOMER_INDUSTRY", 4),
    CUSTOMER_INDUSTRY_GOVERNMENT("客户所属行业", "政府", "CUSTOMER_INDUSTRY", 5),
    CUSTOMER_INDUSTRY_MANUFACTURING("客户所属行业", "制造业", "CUSTOMER_INDUSTRY", 6),
    CUSTOMER_INDUSTRY_SERVICE("客户所属行业", "服务业", "CUSTOMER_INDUSTRY", 7),
    CUSTOMER_INDUSTRY_ENERGY("客户所属行业", "能源", "CUSTOMER_INDUSTRY", 8),
    CUSTOMER_INDUSTRY_RETAIL("客户所属行业", "零售", "CUSTOMER_INDUSTRY", 9),
    CUSTOMER_INDUSTRY_MEDIA("客户所属行业", "媒体", "CUSTOMER_INDUSTRY", 10),
    CUSTOMER_INDUSTRY_ENTERTAINMENT("客户所属行业", "娱乐", "CUSTOMER_INDUSTRY", 11),
    CUSTOMER_INDUSTRY_ADVISORY("客户所属行业", "咨询", "CUSTOMER_INDUSTRY", 12),
    CUSTOMER_INDUSTRY_NON_PROFIT("客户所属行业", "非盈利事业", "CUSTOMER_INDUSTRY", 13),
    CUSTOMER_INDUSTRY_PUBLIC("客户所属行业", "公共事业", "CUSTOMER_INDUSTRY", 14),
    CUSTOMER_INDUSTRY_OTHER("客户所属行业", "其他", "CUSTOMER_INDUSTRY", 15),

    /**
     * 体检人数
     */
    MEDICAL_EXAMINATION_NUMBER_ONE("体检人数", "0—50（含）", "MEDICAL_EXAMINATION_NUMBER", 1),
    MEDICAL_EXAMINATION_NUMBER_TOW("体检人数", "50—100（含）", "MEDICAL_EXAMINATION_NUMBER", 2),
    MEDICAL_EXAMINATION_NUMBER_THREE("体检人数", "100—300（含）", "MEDICAL_EXAMINATION_NUMBER", 3),
    MEDICAL_EXAMINATION_NUMBER_FOUR("体检人数", "300—500（含）", "MEDICAL_EXAMINATION_NUMBER", 4),
    MEDICAL_EXAMINATION_NUMBER_FIVE("体检人数", "500—1000（含）", "MEDICAL_EXAMINATION_NUMBER", 5),
    MEDICAL_EXAMINATION_NUMBER_SIX("体检人数", "1000——1500（含）", "MEDICAL_EXAMINATION_NUMBER", 6),
    MEDICAL_EXAMINATION_NUMBER_SEVEN("体检人数", "1500——2000（含）", "MEDICAL_EXAMINATION_NUMBER", 7),
    MEDICAL_EXAMINATION_NUMBER_EIGHT("体检人数", "2000以上", "MEDICAL_EXAMINATION_NUMBER", 8),

    /**
     * 体检标准
     */
    MEDICAL_EXAMINATION_STANDARD_ONE("体检标准", "0—100（含）", "MEDICAL_EXAMINATION_STANDARD", 1),
    MEDICAL_EXAMINATION_STANDARD_TOW("体检标准", "100—300（含）", "MEDICAL_EXAMINATION_STANDARD", 2),
    MEDICAL_EXAMINATION_STANDARD_THREE("体检标准", "300—500（含）", "MEDICAL_EXAMINATION_STANDARD", 3),
    MEDICAL_EXAMINATION_STANDARD_FOUR("体检标准", "500—1000（含）", "MEDICAL_EXAMINATION_STANDARD", 4),
    MEDICAL_EXAMINATION_STANDARD_FIVE("体检标准", "1000—1500（含）", "MEDICAL_EXAMINATION_STANDARD", 5),
    MEDICAL_EXAMINATION_STANDARD_SIX("体检标准", "1500——2000（含）", "MEDICAL_EXAMINATION_STANDARD", 6),
    MEDICAL_EXAMINATION_STANDARD_SEVEN("体检标准", "2000以上", "MEDICAL_EXAMINATION_STANDARD", 7),

    /**
     * 客户状态
     */
    CUSTOMER_STATE_EFFECTIVE("客户状态", "有效", "CUSTOMER_STATE", 1),
    CUSTOMER_STATE_INVALID("客户状态", "无效", "CUSTOMER_STATE", 2),

    /**
     * 尊享服务包状态
     */
    ZX_SERVICE_STATE_ACTIVE("服务包状态", "有效", "SERVICE_STATE", 1),
    ZX_SERVICE_STATE_INVALID("服务包状态", "无效", "SERVICE_STATE", 2),

    /**
     * 尊享服务状态
     */
    ZX_SERVICE_ACTIVE("尊享服务状态", "有效", "ZX_SERVICE_STATE", 1),
    ZX_SERVICE_INVALID("尊享服务状态", "无效", "ZX_SERVICE_STATE", 2),

    MEDICAL_CARD_INSTANCE_LEVEL("卡等级", "普通卡", "CARD_LEVEL", 1),
    MEDICAL_CARD_TEMPLATE_SERVICE_PACKAGE_UNIT_MONTH("服务包单位", "月", "unit", 1),
    MEDICAL_CARD_TEMPLATE_SERVICE_PACKAGE_UNIT_DAY("服务包单位", "日", "unit", 2),
    MEDICAL_CARD_TEMPLATE_SERVICE_PACKAGE_UNIT_YEAR("服务包单位", "年", "unit", 3),

    /**
     * 权限类型
     */
    PERMISSION_MENU("权限类型", "菜单", "PERMISSION_TYPE", 1),
    PERMISSION_FILE("权限类型", "文件", "PERMISSION_TYPE", 2),
    PERMISSION_DATA("权限类型", "数据", "PERMISSION_TYPE", 3),

    /**
     * 短信场景
     */
    MESSAGE_REGISTER_CODE("消息场景", "注册获取验证码", "message_scene", 1),
    MESSAGE_MOBILE_LOGIN("消息场景", "手机验证码快捷登录", "message_scene", 2),
    MESSAGE_APPOINTMENT_NOTICE("消息场景", "预约信息确认通知", "message_scene", 3),
    MESSAGE_MEDICAL_EIGHT_CLOCK("消息场景", "体检前 1 天 20：00 通知", "message_scene", 4),
    MESSAGE_FINISH_SERVER("消息场景", "后台点击完成服务", "message_scene", 5),
    MESSAGE_RECHARGE_SUCCESS("消息场景", "充值成功", "message_scene", 6),
    MESSAGE_BIRTHDAY_CARE("消息场景", "生日关怀", "message_scene", 7),
    MESSAGE_REPORT_GENERATION("消息场景", "体检报告生成通知", "message_scene", 8),
//    MESSAGE_APPOINTMENT_CONFIRM("消息场景", "预约信息确认通知", "message_scene", 8),

    /**
     * 角色类型 超级管理员 系统管理员 普通用户
     */
    ROLE_ADMIN("角色类型", "超级管理员", "ROLE_TYPE", 1),
    ROLE_SYS("角色类型", "系统管理员", "ROLE_TYPE", 2),
    ROLE_GENERAL_USER("角色类型", "普通用户", "ROLE_TYPE", 3),

    /**
     * 任务类型
     */
    TASK_TYPE_ONCE("任务类型", "一次性任务", "TASK_TYPE", 1),
    TASK_TYPE_DAILY("任务类型", "日常化任务", "TASK_TYPE", 2),

    /**
     * 任务状态
     */
    TASK_STATE_VALID("任务状态", "有效", "TASK_STATE", 1),
    TASK_STATE_INVALID("任务状态", "无效", "TASK_STATE", 2),

    /**
     * 任务完成方式
     */
    TASK_COMPLETION_METHOD_SINGLE("任务完成方式", "单次", "TASK_COMPLETION_METHOD", 1),
    TASK_COMPLETION_METHOD_REPEATEDLY("任务完成方式", "多次", "TASK_COMPLETION_METHOD", 2),

    /**
     * 任务交互方式
     */
    TASK_INTERACTIVE_MODE_INSIDE("任务交互方式", "内部跳转", "TASK_INTERACTIVE_MODE", 1),
    TASK_INTERACTIVE_MODE_OUTSIDE("任务交互方式", "外链H5", "TASK_INTERACTIVE_MODE", 2),

    /**
     * 任务完成状态
     */
    TASK_COMPLETE_STATE_UNDONE("任务完成状态", "未完成", "TASK_COMPLETE_STATE", 1),
    TASK_COMPLETE_STATE_COMPLETED("任务完成状态", "已完成", "TASK_COMPLETE_STATE", 2),

    MESSAGE_ALREADY_READ("消息状态", "已读", "MESSAGE_READER_STATE", 2),
    MESSAGE_UNREAD("消息状态", "未读", "MESSAGE_READER_STATE", 1),
    MESSAGE_TYPE_SYSTEM("消息类型", "官方消息", "message_type", 1),
    MESSAGE_TYPE_ACCOUNT("消息类型", "账户通知", "message_type", 2),
    MESSAGE_TYPE_SERVER("消息类型", "服务通知", "message_type", 3),
    MESSAGE_TYPE_LOGISTICS_ASSISTANT("消息类型", "物流助手", "message_type", 4),

    /**
     * 健康档案关系
     */
    ONESELF("健康档案关系", "本人", "RELATION", 1),
    PARENT("健康档案关系", "父母", "RELATION", 2),
    CHILDREN("健康档案关系", "子女", "RELATION", 3),
    SPOUSE("健康档案关系", "配偶", "RELATION", 4),
    FRIEND("健康档案关系", "朋友", "RELATION", 5),

    /**
     * 健康档案状态
     */
    HEALTH_VALID("健康档案状态", "有效", "HEALTH_STATE", 1),
    HEALTH_INVALID("健康档案状态", "无效", "HEALTH_STATE", 2),


    /**
     * 用户健康币记录类型
     */
    USER_HEALTH_COIN_RECORDS_TYPE_INCOME("用户健康币记录类型", "收入", "USER_HEALTH_COIN_RECORDS_TYPE", 1),
    USER_HEALTH_COIN_RECORDS_TYPE_PAY("用户健康币记录类型", "支出", "USER_HEALTH_COIN_RECORDS_TYPE", 2),

    /**
     * 用户账户金额记录类型
     */
    USER_ACCOUNT_AMOUNT_RECORDS_TYPE_INCOME("用户账户金额记录类型", "收入", "USER_ACCOUNT_AMOUNT_RECORDS_TYPE", 1),
    USER_ACCOUNT_AMOUNT_RECORDS_TYPE_PAY("用户账户金额记录类型", "支出", "USER_ACCOUNT_AMOUNT_RECORDS_TYPE", 2),

    /**
     * 套餐评价类型
     */
    PLAN_COMMENT_TYPE_HAVE_IMAGE("套餐评价类型", "有图", "PLAN_COMMENT_TYPE", 1),
    PLAN_COMMENT_TYPE_NO_IMAGE("套餐评价类型", "无图", "PLAN_COMMENT_TYPE", 2),

    /**
     * 是否显示(1、显示；2、隐藏)
     */
    SHOW_YES("是否显示", "显示", "IS_SHOW", 1),
    SHOW_NO("是否显示", "隐藏", "IS_SHOW", 2),

    /**
     * 是否显示(1、显示；2、隐藏)
     */
    IS_YES("是否关联规格", "是", "IS_RELATION_SPECS", 1),
    IS__NO("是否关联规格", "否", "IS_RELATION_SPECS", 2),

    /**
     * 是否
     */
    YES("是否", "是", "YES_OR_NO", 1),
    NO("是否", "否", "YES_OR_NO", 2),

    /**
     * 健康档案审批状态
     */
    HEALTH_FILE_APPROVAL_STATUS_TO_BE_PROCESSED("健康档案审批状态", "待处理", "HEALTH_FILE_APPROVAL_STATUS", 1),
    HEALTH_FILE_APPROVAL_STATUS_APPROVED("健康档案审批状态", "已同意", "HEALTH_FILE_APPROVAL_STATUS", 2),
    HEALTH_FILE_APPROVAL_STATUS_REJECTED("健康档案审批状态", "已拒绝", "HEALTH_FILE_APPROVAL_STATUS", 3),
    HEALTH_FILE_APPROVAL_STATUS_PLATFORM("健康档案审批状态", "等待平台处理", "HEALTH_FILE_APPROVAL_STATUS", 4),

    /**
     * 档案申请来源
     */
    HEALTH_FILE_APPLY_SOURCE_CREATE("档案申请来源", "档案创建", "HEALTH_FILE_APPLY_SOURCE", 1),
    HEALTH_FILE_APPLY_SOURCE_ASSOCIATION("档案申请来源", "档案关联", "HEALTH_FILE_APPLY_SOURCE", 2),

    /**
     * 档案申请与本人关系
     */
    RELATIONSHIP_WITH_ME_PARENTS("与本人关系", "父母", "RELATIONSHIP_WITH_ME", 1),
    RELATIONSHIP_WITH_ME_CHILD("与本人关系", "子女", "RELATIONSHIP_WITH_ME", 2),
    RELATIONSHIP_WITH_ME_SPOUSE("与本人关系", "配偶", "RELATIONSHIP_WITH_ME", 3),
    RELATIONSHIP_WITH_ME_FRIEND("与本人关系", "朋友", "RELATIONSHIP_WITH_ME", 4),

    /**
     * 兑换券使用记录状态
     */
    CONVERT_COUPON_RECORD_APPLY("兑换券申请记录状态","已申请","CONVERT_COUPON_RECORD_STATE",1),
    CONVERT_COUPON_RECORD_ACCEPT("兑换券申请记录状态","已受理","CONVERT_COUPON_RECORD_STATE",2),
    CONVERT_COUPON_RECORD_FINISH("兑换券申请记录状态","已完成","CONVERT_COUPON_RECORD_STATE",3),
    CONVERT_COUPON_RECORD_CANCEL("兑换券申请记录状态","已取消","CONVERT_COUPON_RECORD_STATE",4),

    /**
     * 尊享服务场景
     */
    ZX_SERVICE_YH_COUPON("尊享服务场景","赠送优惠券","SERVICE_SCENE",1),
    ZX_SERVICE_COUPON("尊享服务场景","赠送兑换券","SERVICE_SCENE",2),
    ZX_SERVICE_MQB("尊享服务场景","返还麻雀币","SERVICE_SCENE",3),
    /**
     * 商城直通车显示状态
     */
    MALL_THROUGH_TRAIN_DISPLAY("商城直通车显示状态", "显示", "MALL_THROUGH_TRAIN", 1),
    MALL_THROUGH_TRAIN_HIDE("商城直通车显示状态", "隐藏", "MALL_THROUGH_TRAIN", 2),

    /**
     * 签到展示类型
     */
    CHECK_IN_SHOW_TYPE_GENERAL("签到展示类型", "通用内容", "CHECK_IN_SHOW_TYPE", 1),
    CHECK_IN_SHOW_TYPE_FESTIVAL("签到展示类型", "节日内容", "CHECK_IN_SHOW_TYPE", 2),

    /**
     * 签到内容类型
     */
    CHECK_IN_CONTENT_TYPE_LIFE("签到内容类型", "生活小贴士", "CHECK_IN_CONTENT_TYPE", 1),
    CHECK_IN_CONTENT_TYPE_MEDICINE("签到内容类型", "医学科普", "CHECK_IN_CONTENT_TYPE", 2),
    CHECK_IN_CONTENT_TYPE_HEALTH("签到内容类型", "健康常识", "CHECK_IN_CONTENT_TYPE", 3),

    /**
     * 默认地址
     */
    DEFAULT_ADDRESS_TRUE("是否默认地址", "是", "IS_TRUE", 1),
    DEFAULT_ADDRESS_FALSE("是否默认地址", "否", "IS_FALSE", 2),
    /**
     * 签到所属节日
     */
    CHECK_IN_BELONG_FESTIVAL_NEW_YEARS("签到所属节日", "元旦", "CHECK_IN_BELONG_FESTIVAL", 1),
    CHECK_IN_BELONG_FESTIVAL_CHINESE_NEW_YEAR("签到所属节日", "春节", "CHECK_IN_BELONG_FESTIVAL", 2),
    CHECK_IN_BELONG_FESTIVAL_CHING_MING("签到所属节日", "清明节", "CHECK_IN_BELONG_FESTIVAL", 3),
    CHECK_IN_BELONG_FESTIVAL_LABOR_DAY("签到所属节日", "劳动节", "CHECK_IN_BELONG_FESTIVAL", 4),
    CHECK_IN_BELONG_FESTIVAL_DRAGON_BOAT("签到所属节日", "端午节", "CHECK_IN_BELONG_FESTIVAL", 5),
    CHECK_IN_BELONG_FESTIVAL_MID_AUTUMN("签到所属节日", "中秋节", "CHECK_IN_BELONG_FESTIVAL", 6),
    CHECK_IN_BELONG_FESTIVAL_NATIONAL_DAY("签到所属节日", "国庆节", "CHECK_IN_BELONG_FESTIVAL", 7),

    /**
     * 商城商品状态
     */
    GY_GOOD_STATE_DWS("商品状态", "待完善", "GY_GOOD_STATE", 1),
    GY_GOOD_STATE_DFB("商品状态", "待发布", "GY_GOOD_STATE", 2),
    GY_GOOD_STATE_DSP("商品状态", "待审批", "GY_GOOD_STATE", 3),
    GY_GOOD_STATE_SP_FAIL("商品状态", "审批失败", "GY_GOOD_STATE", 4),
    GY_GOOD_STATE_SP_SUCCESS("商品状态", "审批成功", "GY_GOOD_STATE", 5),
    GY_GOOD_STATE_YSJ("商品状态", "已上架", "GY_GOOD_STATE", 6),
    GY_GOOD_STATE_YXJ("商品状态", "已下架", "GY_GOOD_STATE", 7),

    GY_GOOD_UP_FLAG_N("商品是否上架","未上架","GY_GOOD_UP_FLAG",1),
    GY_GOOD_UP_FLAG_Y("商品是否上架","已上架","GY_GOOD_UP_FLAG",2),

    /**
     * 商品配置内容类型
     */
    PRODUCT_CONFIG_CONTENT_TYPE_GOODS("商品配置内容类型", "普通商品", "PRODUCT_CONFIG_CONTENT_TYPE", 1),
    PRODUCT_CONFIG_CONTENT_TYPE_PLAN("商品配置内容类型", "体检套餐", "PRODUCT_CONFIG_CONTENT_TYPE", 2),

    /**
     * 充值订单状态
     */
    RECHARGE_ORDER_STATUS_UNPAID("充值订单状态", "待支付", "RECHARGE_ORDER_STATUS", 1),
    RECHARGE_ORDER_STATUS_ALREADY_PAID("充值订单状态", "已支付", "RECHARGE_ORDER_STATUS", 2),

    /**
     * 是否制卡套餐 1是2否
     */
    CARD_MEDICAL_PLAN_Y("是否制卡套餐", "是", "CARD_MEDICAL_PLAN", 1),
    CARD_MEDICAL_PLAN_N("是否制卡套餐", "否", "CARD_MEDICAL_PLAN", 2),

    /**
     * 商品订单类型
     */
    GOODS_ORDER_TYPE_GOODS("商品订单类型", "商品订单", "GOODS_ORDER_TYPE", 1),
    GOODS_ORDER_TYPE_GENE("商品订单类型", "基因订单", "GOODS_ORDER_TYPE", 2),
    GOODS_ORDER_TYPE_TUMOR("商品订单类型", "肿瘤订单", "GOODS_ORDER_TYPE", 3),

    /**
     * 退款状态
     */
    REFUND_STATE_REFUNDING("商品退款状态", "退款中", "GY_REFUND_STATE", 1),
    REFUND_STATE_SUCCESS("商品退款状态", "退款成功", "GY_REFUND_STATE", 2),
    REFUND_STATE_FAIL("商品退款状态", "退款失败", "GY_REFUND_STATE", 3),

    /**
     * 退款类型
     */
    REFUND_TYPE_REFUND("商品退款类型", "仅退款", "GY_REFUND_TYPE", 1),
    REFUND_TYPE_REFUND_RETURN("商品退款类型", "退款/退货", "GY_REFUND_TYPE", 2),

    /**
     * 商品订单配送方式
     */
    SEND_EXPRESS("商品订单配送方式", "快递公司", "SEND_METHOD_TYPE", 1),

    /**
     * 是否签收
     */
    IS_RECEIVE_YES("是否签收", "是", "IS_RECEIVE", 1),
    IS_RECEIVE_NO("是否签收", "否", "IS_RECEIVE", 2),

    /**
     * 商品订单支付标识
     */
    IS_MAIN_PAY_MAIN("商品订单支付标识", "主订单支付", "IS_MAIN_PAY", 1),
    IS_MAIN_PAY_CHILD("商品订单支付标识", "子订单支付", "IS_MAIN_PAY", 2),

    /**
     * 商品订单状态
     */
    GOODS_ORDER_STATE_PENDING_PAYMENT("商品订单状态", "待付款", "GOODS_ORDER_STATE", 1),
    GOODS_ORDER_STATE_PENDING_SHIP("商品订单状态", "待发货", "GOODS_ORDER_STATE", 2),
    GOODS_ORDER_STATE_PENDING_RECEIPT("商品订单状态", "待收货", "GOODS_ORDER_STATE", 3),
    GOODS_ORDER_STATE_PENDING_EVALUATION("商品订单状态", "待评论", "GOODS_ORDER_STATE", 4),
    GOODS_ORDER_STATE_COMPLETE("商品订单状态", "已完成", "GOODS_ORDER_STATE", 5),
    GOODS_ORDER_STATE_CANCEL("商品订单状态", "已取消", "GOODS_ORDER_STATE", 6),
    GOODS_ORDER_STATE_REFUND("商品订单状态", "退款中", "GOODS_ORDER_STATE", 7),
    GOODS_ORDER_STATE_PENDING_SERVICE("商品订单状态", "待服务", "GOODS_ORDER_STATE", 12),
    GOODS_ORDER_STATE_CLOSE("商品订单状态", "交易关闭", "GOODS_ORDER_STATE", 22),

    /**
     * 商品预定义类目
     */
    GOODS_TYPE_GENE("商品预定义类目", "基因", "GOODS_TYPE", 10001),
    GOODS_TYPE_TUMOR("商品预定义类目", "肿瘤", "GOODS_TYPE", 10002),

    /**
     * 扫码支付
     */
    SCANCODE_ORDER_WAIT_PAY("商户扫码订单状态", "待付款", "ORDER_STATE", 1),
    SCANCODE_ORDER_PAY("商户扫码订单状态", "已付款", "ORDER_STATE", 2),

    /**
     * 商家信息上下架
     */
    MERCHANT_UP("商户信息状态","上架","MERCHANT_STATE",1),
    MERCHANT_DOWN("商户信息状态","下架","MERCHANT_STATE",2),

    /**
     * 充值等级
     */
    RECHARGE_CHEAP("充值等级","特惠","RECHARGE_GRADE",165),
    RECHARGE_EXTREME("充值等级","至尊","RECHARGE_GRADE",435),
    RECHARGE_PLATINA("充值等级","白金","RECHARGE_GRADE",785),
    RECHARGE_GOLD("充值等级","黄金","RECHARGE_GRADE",995),
    RECHARGE_PLATINUM("充值等级","铂金","RECHARGE_GRADE",1510),
    RECHARGE_DIAMOND("充值等级","钻石","RECHARGE_GRADE",1870),
    RECHARGE_CROWN("充值等级","皇冠","RECHARGE_GRADE",2515),

    /**
     *  用户充值类型
     */
    BALANCE_RECHARGE("充值类型","余额充值","RECHARGE_TYPE",1),
    ACTIVITY_RECHARGE("充值类型","充值返现","RECHARGE_TYPE",2),

    /**
     * 消息任务类型
     */
    JOB_TASK_TYPE_SMS("消息任务类型","短信","JOB_TASK_TYPE",1),
    JOB_TASK_TYPE_MESSAGE("消息任务类型","消息","JOB_TASK_TYPE",2),

    /**
     * 消息任务状态
     */
    JOB_TASK_STATE_PROCESSING("消息任务类型","进行中","JOB_TASK_STATE",1),
    JOB_TASK_STATE_PAUSE("消息任务类型","暂停","JOB_TASK_STATE",2),
    JOB_TASK_STATE_COMPLETED("消息任务类型","已完成","JOB_TASK_STATE",3),
    JOB_TASK_STATE_INVALID("消息任务类型","作废","JOB_TASK_STATE",4),
    ;
    @Getter
    private String title;

    @Getter
    private String name;

    @Getter
    private String code;

    @Getter
    private Integer value;

    SysDictEnum(String title, String name, String code, Integer value) {
        this.title = title;
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public static List<SysDictEnum> getEnumList(String code) {
        List<SysDictEnum> list = Lists.newArrayList();
        for (SysDictEnum type : SysDictEnum.values()) {
            if (type.getCode().equals(code)) {
                list.add(type);
            }
        }
        return list;
    }

    public static String getLabel(String code, String value) {
        List<SysDictEnum> enumList = getEnumList(code);
        String valueLabel = "";
        for (SysDictEnum sysDictEnum : enumList) {
            if (sysDictEnum.getValue().equals(Integer.valueOf(value))) {
                valueLabel = sysDictEnum.getName();
                break;
            }
        }
        return valueLabel;
    }
}
