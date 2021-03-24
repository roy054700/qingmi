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
        CustomerUser user = customerUserService.getById(TokenUtil.getTokenUserId());
        //查询关注人数和被关注的人数
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("create_user_id", TokenUtil.getTokenUserId());
        user.setFollowCount(followService.count(query));
        query = new QueryWrapper<>();
        query.eq("user_id", TokenUtil.getTokenUserId());
        user.setCoverFollowCount(followService.count(query));
        return ResponseUtils.success(user);
    }

}
