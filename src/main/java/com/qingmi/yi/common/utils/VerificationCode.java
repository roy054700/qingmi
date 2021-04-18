package com.qingmi.yi.common.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
//导入可选配置类
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;

import com.tencentcloudapi.sms.v20190711.models.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机验证码
 * @Author: 李龙真
 * @Date: 2021/4/14 15:41
 */
public class VerificationCode {
    private static Map<String,String> map = new HashMap();

    /**
     * 发送手机验证码
     * @param phoneNumber 手机号
     * @return
     */
    public static void send(ShortMmessage shortMmessage,String phoneNumber){

        String code = getCode();
        //保存验证码和手机号到Session
        save(code,phoneNumber);
        phoneNumber="86"+phoneNumber;
        try{
            Credential cred = new Credential(shortMmessage.getSecretId(), shortMmessage.getSecretKey());

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint(shortMmessage.getEndpoint());

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID(shortMmessage.getTemplateID());
            req.setSign(shortMmessage.getSign());

            String[] templateParamSet1 = {code};//验证码需要生成
            req.setTemplateParamSet(templateParamSet1);

            req.setSmsSdkAppid(shortMmessage.getSmsSdkAppid());

            SendSmsResponse resp = client.SendSms(req);

            System.out.println(SendSmsResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }

    /**
     * 生成验证码
     * @return
     */
    public static String getCode(){
        String s = Long.toString(System.nanoTime());
        return s.substring(s.length()-6);
    }

    /**
     * 保存验证码和手机号到session
     */
    public static void save(String code,String phoneNumber){
        map.put(phoneNumber,code);
    }

    /**
     * 匹配验证码
     * @param code
     * @param phoneNumber
     * @return
     */
    public static boolean matchingCode(String code,String phoneNumber){
        String attribute = map.get(phoneNumber);

        return code.equals(attribute);
    }
    public static void main(String [] args) {

        //send("13585825640");

//        try{
//
//            Credential cred = new Credential("AKIDf6LK4dU85ufOs5jNAgx3uUnkEcsuphha", "JPPCi04rMXR4QYWMxgAUdYO4UwVw98sN");
//
//            HttpProfile httpProfile = new HttpProfile();
//            httpProfile.setEndpoint("sms.tencentcloudapi.com");
//
//            ClientProfile clientProfile = new ClientProfile();
//            clientProfile.setHttpProfile(httpProfile);
//
//            SmsClient client = new SmsClient(cred, "", clientProfile);
//
//            SendSmsRequest req = new SendSmsRequest();
//            String[] phoneNumberSet1 = {"8618817529815"};
//            req.setPhoneNumberSet(phoneNumberSet1);
//
//            req.setTemplateID("921010");
//            req.setSign("上海清谧文化交流中心");
//
//            String[] templateParamSet1 = {"3586"};
//            req.setTemplateParamSet(templateParamSet1);
//
//            req.setSmsSdkAppid("1400502936");
//
//            SendSmsResponse resp = client.SendSms(req);
//
//            System.out.println(SendSmsResponse.toJsonString(resp));
//        } catch (TencentCloudSDKException e) {
//            System.out.println(e.toString());
//        }
//
    }
}
