package com.qingmi.yi.modular.forum.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.TokenUtil;
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
        //查询关注人数和被关注的人数
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("create_user_id", id);
        user.setFollowCount(followService.count(query));
        query = new QueryWrapper<>();
        query.eq("user_id", id);
        user.setCoverFollowCount(followService.count(query));
        List<CustomerUser> list = new ArrayList<>();
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
        //如果当前用户没有绑定手机号，提示绑定手机号
//        if(StringUtils.isEmpty(one.getPhoneNumber())){
//            return ResponseUtils.phone(TokenUtil.getToken(one));
//        }
        return ResponseUtils.success(TokenUtil.getToken(one));
    }

    /**
     * 当前微信用户不存在即插入并查询，存在则查询
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

}
