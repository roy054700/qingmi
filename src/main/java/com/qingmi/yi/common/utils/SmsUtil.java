package com.qingmi.yi.common.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.qingmi.yi.common.constant.Constant;
import com.qingmi.yi.common.constant.MqQueueConstant;
import com.qingmi.yi.common.dto.SmsLogDTO;

import java.util.Date;
import java.util.Map;

public class SmsUtil {

    public static final SmsLogDTO SMS_LOG_DTO = new SmsLogDTO();
   // private static RabbitTemplate rabbitTemplate = SpringContextUtil.getBean(RabbitTemplate.class);

    private static   String domain = "dysmsapi.aliyuncs.com";
    private static String product = "Dysmsapi";

    private static SendSmsResponse sendSms(String mobile, String templateParam, String templateCode) throws Exception {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", Constant.SMS_ACCESSID, Constant.SMS_SECRETKEY);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(mobile);
        request.setSignName(Constant.SIGN_NAME);
        request.setTemplateCode(templateCode);
        request.setTemplateParam(templateParam);
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }

    /**
     * 发送短信
     * @param mobile
     * @param param
     * @return
     */
    public static boolean onSendSms(String mobile,String content,Map param,String smsType) throws Exception{
        boolean flag=false;
        try {
            SendSmsResponse sendSmsResponse=sendSms(mobile,content,String.valueOf(param.get("TemplateCode")));
            if(sendSmsResponse.getCode().equals("OK")){
                flag= true;
            }else{
                flag=false;
                throw new RuntimeException(sendSmsResponse.getMessage());
            }
        } finally {
            saveSMSLog(mobile, content, smsType);
        }
        return flag;
    }
    /**
     * 保存短信发送日志
     *
     * @param mobiles
     * @param content
     * @param smsType
     */
    private static void saveSMSLog(String mobiles, String content, String smsType) {
        SmsLogDTO smsLogDTO = SMS_LOG_DTO;
        smsLogDTO.setMobile(mobiles).setContent(content).setSmsType(smsType).setSendDate(new Date()).setFormPlat(Constant.FORM_PLAT);
        //rabbitTemplate.convertAndSend(MqQueueConstant.SMS_LOG_QUEUE, smsLogDTO);
    }
}
