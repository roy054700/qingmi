package com.qingmi.yi.modular.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.TokenUtil;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.modular.forum.model.Follow;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import com.qingmi.yi.modular.forum.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public R<?> home(){
        Long userId = TokenUtil.getTokenUserId();
        CustomerUser user = customerUserService.getById(userId);
        //查询关注人数和被关注的人数
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("create_user_id", userId);
        user.setFollowCount(followService.count(query));
        query = new QueryWrapper<>();
        query.eq("user_id", userId);
        user.setCoverFollowCount(followService.count(query));
        List<CustomerUser> list = new ArrayList<>();
        list.add(user);
        return ResponseUtils.success(list);
    }

}
