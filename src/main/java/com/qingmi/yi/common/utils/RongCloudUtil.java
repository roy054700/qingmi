package com.qingmi.yi.common.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingmi.yi.common.vo.SysUserVo;
import io.rong.RongCloud;
import io.rong.messages.RcCmdMessage;
import io.rong.messages.TxtMessage;
import io.rong.methods.user.User;
import io.rong.models.Result;
import io.rong.models.message.BroadcastMessage;
import io.rong.models.message.PrivateMessage;
import io.rong.models.message.SystemMessage;
import io.rong.models.push.*;
import io.rong.models.response.*;
import io.rong.models.user.UserModel;


/**
 * @author 冷言丶冷语
 * @date 2019-12-13 13:58
 **/
public class RongCloudUtil {

    private static RongCloud rongCloud;
    private static final String APP_KEY = "8luwapkv8bxel";
    private static final String APP_SECRET = "NstldzlKvE8";
    static {
        rongCloud = RongCloud.getInstance(APP_KEY, APP_SECRET);
    }
    public static String registerUser(SysUserVo userVo) throws Exception {
        User user = rongCloud.user;
        UserModel userModel = new UserModel()
                .setId(userVo.getId())
                .setName(userVo.getNickName())
                .setPortrait(userVo.getPicture());
        TokenResult result = user.register(userModel);
        System.out.println("getToken:  " + result.toString());
        return result.toString();
    }

    public static String refreshUser(SysUserVo userVo) throws Exception {
        UserModel user = new UserModel()
                .setId(userVo.getId())
                .setName(userVo.getNickName())
                .setPortrait(userVo.getPicture());

        Result result = (ResponseResult) rongCloud.user.update(user);
        return result.toString();
    }

    /**
     * 查询用户信息
     * @param userVo 系统用户对象
     * @return
     * @throws Exception
     */
    public static JSONObject getUserInfo(SysUserVo userVo) throws Exception {
        UserModel user = new UserModel()
                .setId(userVo.getId());
        UserResult result = rongCloud.user.get(user);
        System.out.println("getUserInfo:  " + result.toString());
        return JSON.parseObject(result.toString());
    }

    /**
     * 发送系统消息
     * @param txtMessage 消息类型
     * @param targetIds 目标id集合
     * @param senderId 发送者id
     * @return String
     * @throws Exception
     */
    public static String sendSystemMsg(TxtMessage txtMessage,String[] targetIds,String senderId) throws Exception {
        JSONObject param=new JSONObject();
        param.put("pushData",txtMessage.getContent());
        SystemMessage systemMessage = new SystemMessage()
                .setSenderId(senderId)
                .setTargetId(targetIds)
                .setObjectName(txtMessage.getType())
                .setContent(txtMessage)
                .setPushContent(txtMessage.getContent())
                .setPushData(JSON.toJSONString(param))
                .setIsPersisted(0)
                .setIsCounted(0)
                .setContentAvailable(0);
        ResponseResult result = rongCloud.message.system.send(systemMessage);
        return result.toString();
    }

    /**
     * 发送广播消息
     * @param txtMessage 消息类型
     * @param senderId 发送者id
     * @return
     * @throws Exception
     */
    public static String sendBroadcast(TxtMessage txtMessage,String senderId) throws Exception {
        JSONObject param=new JSONObject();
        param.put("pushData",txtMessage.getContent());
        BroadcastMessage message = new BroadcastMessage()
                .setSenderId(senderId)
                .setObjectName(txtMessage.getType())
                .setContent(txtMessage)
                .setPushContent(txtMessage.getContent())
                .setPushData(JSON.toJSONString(param));
        ResponseResult result = rongCloud.message.system.broadcast(message);
        return  result.toString();
    }
    /**
     * 广播消息撤回测试
     */
    public static boolean recallBroadcast(String senderId,RcCmdMessage rcCmdMessage) throws Exception {
        BroadcastMessage message = new BroadcastMessage()
                .setSenderId(senderId)
                .setObjectName(rcCmdMessage.getType())
                .setContent(rcCmdMessage);
        ResponseResult result = rongCloud.message.system.broadcast(message);
        System.out.println("recall broadcast:  " + result.toString());
        return result.getCode().equals(200);
    }

    /**
     * 发送单聊消息
     * @throws Exception
     */
    public static boolean sendPrivate(String senderId,String[]targetIds,TxtMessage txtMessage) throws Exception {
        JSONObject param=new JSONObject();
        param.put("pushData",txtMessage.getContent());
        PrivateMessage privateMessage = new PrivateMessage()
                .setSenderId(senderId)
                .setTargetId(targetIds)
                .setObjectName(txtMessage.getType())
                .setContent(txtMessage)
                .setPushContent("")
                .setPushData(JSON.toJSONString(param))
                .setVerifyBlacklist(0)
                .setIsPersisted(1)
                .setIsCounted(0)
                .setIsIncludeSender(0);

        //发送单聊方法
        ResponseResult publishPrivateResult = rongCloud.message.msgPrivate.send(privateMessage);
        return publishPrivateResult.getCode().equals(200);
    }

    /**
     * 获取历史消息
     * @param date 时间格式2018032810
     * @return 此接口参数URL地址需要进行手动下载消息文件
     * @throws Exception
     */
    public static String getHistory(String date) throws Exception {
        HistoryMessageResult result = (HistoryMessageResult) rongCloud.message.history.get(date);
        System.out.println("get history  message:  " + result.toString());
        return StrUtil.isNotEmpty(result.getUrl())?result.getUrl():"";
    }

    /**
     *  推送
     * @param fromId
     * @param targetIds
     * @param content
     * @return
     * @throws Exception
     */
    public static boolean broadcast(String fromId,String[]targetIds,String content) throws Exception {
        BroadcastModel broadcast = new BroadcastModel();
        broadcast.setFromuserid(fromId);
        broadcast.setPlatform(new String[]{"ios", "android"});
        Audience audience = new Audience();
        audience.setUserid(targetIds);
        broadcast.setAudience(audience);
        Message message = new Message();
        message.setContent(content);
        message.setObjectName("RC:TxtMsg");
        broadcast.setMessage(message);
        Notification notification = new Notification();
        notification.setAlert(content);
        broadcast.setNotification(notification);
        PushResult result = rongCloud.push.message(broadcast);
        return result.getCode().equals(200);
    }

    /**
     * 推送消息
     * @param targetId
     * @param content
     * @return
     * @throws Exception
     */
    public static boolean pushMessage(String[]targetId,String content) throws Exception {
        PushModel pushmodel = new PushModel();
        pushmodel.setPlatform(new String[]{"ios", "android"});
        Audience audience = new Audience();
        audience.setUserid(targetId);
        pushmodel.setAudience(audience);
        Notification notification = new Notification();
        notification.setAlert(content);
        pushmodel.setNotification(notification);
        PushResult result = rongCloud.push.push(pushmodel);
        return result.getCode().equals(200);
    }

    public static void main(String[] args) {
        try {
            boolean flag=sendPrivate("1",new String[]{"123456","1"},new TxtMessage("你好世界","你好世界"));
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
