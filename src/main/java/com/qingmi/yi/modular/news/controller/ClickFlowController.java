package com.qingmi.yi.modular.news.controller;

import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.news.service.impl.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告点击监播
 * @Author: 李龙真
 * @Date: 2021/4/20 18:16
 */
@RestController
@EnableAsync
@RequestMapping("/follow")
public class ClickFlowController {

    @Autowired
    AsynchronousService asynchronousService;//监播
    @RequestMapping(value = "/click")
    @ResponseBody
    public R<?> click(String[] click){
        asynchronousService.clickFollow(click);
        return ResponseUtils.success();
    }
}
