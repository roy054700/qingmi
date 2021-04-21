package com.qingmi.yi.modular.forum.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.enums.ResponseEnum;
import com.qingmi.yi.common.utils.*;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.modular.forum.model.Follow;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import com.qingmi.yi.modular.forum.service.FollowService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 * @Author: 李龙真
 * @Date: 2021/3/12 17:05
 */
@RestController
@RequestMapping("/user")
public class CustomerUserConroller extends BaseController {
    @Autowired
    private CustomerUserService customerUserService;
    @Autowired
    private FollowService followService;

    @Autowired
    private ShortMmessage shortMmessage ;//短信配置数据

    /**
     * 个人主页
     * @return
     */
    @RequestMapping("/home")
    public R<?> home(Long id){
        if(id == 0l){
            id = TokenUtil.getTokenUserId();
        }
        CustomerUser user = customerUserService.getById(id);
        if(user != null && StringUtils.isNotEmpty(user.getBitmapHead())){
            user.setHeadPortrait(user.getBitmapHead());
        }
        //查询关注人数和被关注的人数
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("create_user_id", id);
        user.setFollowCount(followService.count(query));
        query = new QueryWrapper<>();
        query.eq("user_id", id);
        user.setCoverFollowCount(followService.count(query));
        List<CustomerUser> list = new ArrayList<>();
        if(user.getPhoneNumber() != null){
            user.setPhoneNumber(StaticUtil.replace(user.getPhoneNumber()));
        }
        if(user.getLeterBox() != null){
            user.setLeterBox(StaticUtil.replace(user.getLeterBox()));
        }
        list.add(user);
        return ResponseUtils.success(list);
    }


    /**
     * 当前微信用户不存在即插入并查询，存在则查询
     * @param body
     * @return
     */
    @RequestMapping(value = "/register")
    public R<?> register(@RequestBody String body) {
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("openid",user.getOpenid());
        if(customerUserService.count(query) == 0){
            if(user.getSex() == 1){
                user.setSexname("男");
            }else{
                user.setSexname("女");
            }
            customerUserService.save(user);
        }
        CustomerUser one = customerUserService.getOne(query);
        return ResponseUtils.success(TokenUtil.getToken(one));
    }

    /**
     * 更新
     * @param body
     * @return
     */
    @RequestMapping(value = "/update")
    public R<?> update(@RequestBody String body){
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        customerUserService.updateById(user);
        return ResponseUtils.success();
    }


    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/userRegister")
    public R<?> userRegister(@RequestBody String body){
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);

        //匹配验证码
        if(!VerificationCode.matchingCode(user.getCode(),user.getPhoneNumber())){
            return ResponseUtils.success(ResponseEnum.VERIFICATION_CODE_ERROR);
        }
        String pass = DesUtils.encode(user.getPassword());//加密
        user.setPassword(pass);
        customerUserService.save(user);
        return ResponseUtils.success();
    }

    /**
     * 登录——用户名和密码
     * @param body
     * @return
     */
    @RequestMapping(value = "/login")
    public R<?> login(@RequestBody String body) {
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        String pass = DesUtils.encode(user.getPassword());//加密
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("username",user.getUsername());
        query.eq("password",pass);
        CustomerUser one = customerUserService.getOne(query);
        if(one == null){
            return ResponseUtils.success(ResponseEnum.LOGIN_ERROR);
        }
        return ResponseUtils.success(TokenUtil.getToken(one));
    }

    /**
     * 使用手机号登录，用户不存在就注册
     */
    @RequestMapping(value = "/phoneLogin")
    public R<?> phoneLogin(@RequestBody String body) {
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        //匹配验证码
        if(!VerificationCode.matchingCode(user.getCode(),user.getPhoneNumber())){
            return ResponseUtils.success(ResponseEnum.VERIFICATION_CODE_ERROR);
        }
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("phone_number",user.getPhoneNumber());
        CustomerUser one = customerUserService.getOne(query);
        if(one == null){
            user.setUsername(user.getPhoneNumber());
            customerUserService.save(user);
            one = customerUserService.getOne(query);
        }
        return ResponseUtils.success(TokenUtil.getToken(one));
    }

    /**
     * 用户绑定手机号
     * @return
     */
    @RequestMapping(value = "/bindingPhone")
    public R<?> bindingPhone(@RequestBody String body){
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        //判断当前手机号是否被占用
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        String phoneNumber = user.getPhoneNumber();
        query.eq("phone_number",phoneNumber);
        int count = customerUserService.count(query);
        if(count != 0) {//手机已被占用
            return ResponseUtils.success(ResponseEnum.PHONE_NO_REGISTER);
        }
        //匹配验证码
        if(!VerificationCode.matchingCode(user.getCode(),phoneNumber)){
            return ResponseUtils.success(ResponseEnum.VERIFICATION_CODE_ERROR);
        }
        customerUserService.updateById(user);
        return ResponseUtils.success();
    }

    /**
     * 更新密码
     */
    @RequestMapping(value = "/updatePassword")
    public R<?> updatePassword(@RequestBody String body){
        JSONObject json = JSONObject.parseObject(body);
        CustomerUser user = JSON.toJavaObject(json, CustomerUser.class);
        String encode = DesUtils.encode(user.getPassword());
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("username",user.getUsername());
        query.eq("password",encode);
        int count = customerUserService.count(query);
        if(count == 0){//用户名或者密码不正确
            return ResponseUtils.success(ResponseEnum.LOGIN_ERROR);
        }else {
            user.setId(TokenUtil.getTokenUserId());
            encode = DesUtils.encode(user.getNewPassword());
            user.setPassword(encode);
            customerUserService.updateById(user);
            return ResponseUtils.success();
        }
    }
    /**
     * 用户获取手机验证码
     * 根据 type 判断是登录，注册，绑定手机号
     * type 1 登录，2 注册，3 绑定手机号
     * @return
     */
    @RequestMapping(value = "/getCode")
    public R<?> getCode(int type, String phoneNumber){
        if(type == 1){//登录
            if(StringUtils.isNotEmpty(phoneNumber)) {
                VerificationCode.send(shortMmessage, phoneNumber);
            }
        }else if(type == 2){//注册
            //判断当前手机号是否注册
            QueryWrapper<CustomerUser> query = new QueryWrapper<>();
            query.eq("phone_number",phoneNumber);
            int count = customerUserService.count(query);
            if(count != 0){//手机已经注册
                return ResponseUtils.success(ResponseEnum.PHONE_NO_REGISTER);
            }else{
                if(StringUtils.isNotEmpty(phoneNumber)){
                    VerificationCode.send(shortMmessage,phoneNumber);
                }
            }
        }else if(type == 3){//绑定手机号
            //判断当前手机号是否注册
            QueryWrapper<CustomerUser> query = new QueryWrapper<>();
            query.eq("phone_number",phoneNumber);
            int count = customerUserService.count(query);
            if(count != 0){//手机已经注册
                return ResponseUtils.success(ResponseEnum.PHONE_NO_REGISTER);
            }else{
                if(StringUtils.isNotEmpty(phoneNumber)){
                    VerificationCode.send(shortMmessage,phoneNumber);
                }
            }
        }else if(type == 4){//更新密码
            //判断当前手机号是否被别人占用
            QueryWrapper<CustomerUser> query = new QueryWrapper<>();
            query.eq("phone_number",phoneNumber);
            query.ne("id",TokenUtil.getTokenUserId());
            int count = customerUserService.count(query);
            if(count != 0){//手机已经注册
                return ResponseUtils.success(ResponseEnum.PHONE_NO_REGISTER);
            }else{
                if(StringUtils.isNotEmpty(phoneNumber)){
                    VerificationCode.send(shortMmessage,phoneNumber);
                }
            }
        }
        return ResponseUtils.success();
    }

    /**
     * 验证用户名是否存在
     * @return
     */
    @RequestMapping(value = "/verifyUser")
    public R<?> verifyUser(String username){
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("username",username);
        int count = customerUserService.count(query);
        if(count == 0){
            return ResponseUtils.success();
        }else {
            return ResponseUtils.success(ResponseEnum.USER_NAME);
        }
    }


    /**
     * 手机号是否注册
     * @return
     */
    @RequestMapping(value = "/verifPhone")
    public R<?> verifPhone(String phoneNumber){
        QueryWrapper<CustomerUser> query = new QueryWrapper<>();
        query.eq("phone_number",phoneNumber);
        int count = customerUserService.count(query);
        if(count == 0){
            return ResponseUtils.success();
        }else {
            return ResponseUtils.success(ResponseEnum.PHONE_NO_REGISTER);
        }
    }



}
