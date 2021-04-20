package com.qingmi.yi.modular.news.service.impl;

import com.qingmi.yi.common.utils.HttpClientUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 广告 展示监播数组和点击监播数组服务类
 * showFollowList
 * clickFlowwList
 * @Author: 李龙真
 * @Date: 2021/4/20 17:35
 */
@Service
public class AsynchronousService {
    /**
     * 展示监播
     */
    @Async
    public void showFollow(String[] show){
        if(show != null && show.length != 0){
            for(int i = 0; i<show.length;i++){
                HttpClientUtils.httpGet(show[i]);
            }
        }
    }

    /**
     * 点击监播
     */
    @Async
    public void clickFollow(String[] click){
        if(click != null && click.length != 0){
            for(int i = 0; i<click.length;i++){
                HttpClientUtils.httpGet(click[i]);
            }
        }
    }
}
