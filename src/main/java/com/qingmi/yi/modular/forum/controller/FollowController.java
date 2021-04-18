package com.qingmi.yi.modular.forum.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.TokenUtil;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.modular.forum.model.Follow;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import com.qingmi.yi.modular.forum.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 关注
 * @Author: 李龙真
 * @Date: 2021/3/12 16:21
 */
@RestController
@RequestMapping("/follow")
public class FollowController extends BaseController {
    @Autowired
    private FollowService followService;
    @Autowired
    private CustomerUserService CustomerUserService;

    /**
     * 我关注的人
     * @return
     */
    @RequestMapping("/myFollowUser")
    public R<?> myFollowUser(@RequestBody String json){
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id", TokenUtil.getTokenUserId());
        queryWrapper.select("user_id");
        queryWrapper.orderByDesc("create_time");
        List<Follow> list = followService.list(queryWrapper);
        if(list != null && list.size() > 0){
            List<Long> userList = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                userList.add(list.get(i).getUserId());
            }
            JSONObject map =  JSONObject.parseObject(json);
            Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
            Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
            IPage<CustomerUser> iPage = new Page<>(pageNo,pageSize);
            QueryWrapper<CustomerUser> query = new QueryWrapper<>();
            query.in("user_id",userList);
            IPage<CustomerUser> page = CustomerUserService.page(iPage,query);
            return ResponseUtils.success(page.getRecords());
        }else {
            return ResponseUtils.success();
        }
    }
    /**
     * 关注我的人
     * @return
     */
    @RequestMapping("/attentionUser")
    public R<?> attentionUser(@RequestBody String json){
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id", TokenUtil.getTokenUserId());
        queryWrapper.select("user_id");
        queryWrapper.orderByDesc("create_time");
        List<Follow> list = followService.list(queryWrapper);
        if(list != null && list.size() > 0){
            Set<Long> userList = new HashSet<>();
            for(int i=0;i<list.size();i++){
                userList.add(list.get(i).getUserId());
            }
            JSONObject map =  JSONObject.parseObject(json);
            Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
            Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
            IPage<CustomerUser> iPage = new Page<>(pageNo,pageSize);
            QueryWrapper<CustomerUser> query = new QueryWrapper<>();
            query.in("id",userList);
            IPage<CustomerUser> page = CustomerUserService.page(iPage,query);
            return ResponseUtils.success(page.getRecords());
        }else {
            return ResponseUtils.success();
        }
    }


    /**
     * 添加关注 或者取消
     */
    @RequestMapping("/save")
    public R<?> save(Long userId){
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("user_id",userId);
        query.eq("create_user_id",TokenUtil.getTokenUserId());
        int count = followService.count(query);
        if(count == 0){//判断是否关注，如果没有则添加，否则取消
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.setCreateUserId(TokenUtil.getTokenUserId());
            followService.save(follow);
        }else {
            followService.remove(query);
        }
        return ResponseUtils.success(count+"");
    }



}
