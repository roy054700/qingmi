package com.qingmi.yi.common.constant;

/**
 * 消息队列名称常量
 */
public interface MqQueueConstant {

    /*************************************测试环境**********************************************/
    String SYS_SYSTEM_LOG_QUEUE = "sys_system_log_test_queue";
    /**
     * 短信日志队列
     */
    String SMS_LOG_QUEUE = "sms_log_test_queue";

    /*************************************正式环境**********************************************/
//    String SYS_SYSTEM_LOG_QUEUE = "sys_system_log_prod_queue";
//    /**
//     * 短信日志队列
//     */
//    String SMS_LOG_QUEUE = "sms_log_prod_queue";
}
