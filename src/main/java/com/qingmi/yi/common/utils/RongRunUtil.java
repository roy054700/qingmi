package com.qingmi.yi.common.utils;

import com.alibaba.fastjson.JSON;
import com.qingmi.yi.common.constant.Constant;
import com.google.common.collect.Maps;
import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.models.message.SystemMessage;
import io.rong.models.response.ResponseResult;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

import java.util.Map;

/**
 * @author 冷言丶冷语
 * @className RongRunUtil
 * @description
 * @date 2019-10-29 10:31
 **/
public class RongRunUtil {

    private static RongCloud rongCloud;
    private static Integer code=200;

    static {
        String appKey = Constant.RONG_YUN_APP_KEY;
        String appSecret = Constant.RONG_YUN_APP_SECRET;
        rongCloud = RongCloud.getInstance(appKey, appSecret);
    }

    /**
     * 注册用户
     * @param userId
     * @param userName
     * @param portrait 头像
     * @return
     * @throws Exception
     */
    public static String register(String userId,String userName,String portrait) throws Exception {
        UserModel user = new UserModel()
                .setId(userId)
                .setName(userName)
                .setPortrait(portrait);
        TokenResult result = rongCloud.user.register(user);
        if(result.getCode().equals(code)){
            return result.getToken();
        }
        return "";
    }

    /**
     * 发送系统文本消息
     * @param targetIds
     * @param senderId
     * @param txtMessage
     * @return
     * @throws Exception
     */
    public static boolean sendSystem(String [] targetIds,String senderId,TxtMessage txtMessage) throws Exception {
        Map<String,String> param= Maps.newHashMap();
        param.put("pushData",txtMessage.getContent());
        SystemMessage systemMessage = new SystemMessage()
                .setSenderId(senderId)
                .setTargetId(targetIds)
                .setObjectName(txtMessage.getType())
                .setContent(txtMessage)
                .setPushContent(txtMessage.getContent())
                .setPushData(JSON.toJSONString(param))
                .setIsPersisted(1)
                .setIsCounted(1)
                .setContentAvailable(1);
        ResponseResult result = rongCloud.message.system.send(systemMessage);
        if(result.getCode().equals(code)){
           return true;
        }
        return false;
    }

}
