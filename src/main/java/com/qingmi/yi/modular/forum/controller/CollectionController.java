package com.qingmi.yi.modular.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.TokenUtil;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.forum.model.Fabulous;
import com.qingmi.yi.modular.forum.model.WorkCollection;
import com.qingmi.yi.modular.forum.model.Works;
import com.qingmi.yi.modular.forum.service.CollectionService;
import com.qingmi.yi.modular.forum.service.FabulousService;
import com.qingmi.yi.modular.forum.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 作品收藏
 * @Author: 李龙真
 * @Date: 2021/3/11 18:13
 */
@RestController
@RequestMapping("/collection")
public class CollectionController extends BaseController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private WorksService worksService;

    @Autowired
    private FabulousService fabulousService;

    /**
     * 收藏作品
     * @return
     */
    @RequestMapping(value = "/concern")
    public R<?> save(Long workId){
        WorkCollection collection = new WorkCollection();
        collection.setWorkId(workId);
        collection.setCreateUserId(1l);
//        collection.setCreateUserId(TokenUtil.getTokenUserId());
        boolean save = collectionService.save(collection);
        return ResponseUtils.success();
    }


    /**
     * 我收藏作品的个数
     */
    @RequestMapping("/collCount")
    public R<?> collCount(){
        QueryWrapper<WorkCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id",TokenUtil.getTokenUserId());
        int count = collectionService.count(queryWrapper);
        return ResponseUtils.success(count);
    }
    /**
     * 点赞
     */
    @RequestMapping("/like")
    public R<?> like(Long workId){
        Fabulous fabulous = new Fabulous();
        fabulous.setWorkId(workId);
        fabulous.setCreateUserId(TokenUtil.getTokenUserId());
        boolean save = fabulousService.save(fabulous);
        return ResponseUtils.success();
    }


}
