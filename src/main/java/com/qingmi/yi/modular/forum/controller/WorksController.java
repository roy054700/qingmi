package com.qingmi.yi.modular.forum.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.TokenUtil;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.forum.model.*;
import com.qingmi.yi.modular.forum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 作品
 * @Author: 李龙真
 * @Date: 2021/3/10 17:57
 */

@RestController
@RequestMapping("/works/")
public class WorksController extends BaseController {
    @Autowired
    private WorksService worksService;
    @Autowired
    private CustomerUserService customerUserService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private FabulousService fabulousService;

    @Autowired
    private FollowService followService;

    /**
     * 我的收藏作品
     */
    @RequestMapping("collectionList")
    public R<?> collectionList(@RequestBody String body){
        QueryWrapper<WorkCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id",TokenUtil.getTokenUserId());
        List<WorkCollection> list = collectionService.list(queryWrapper);
        List<Long> workIdList = new ArrayList<>();
        for(WorkCollection workCollection : list){
            workIdList.add(workCollection.getWorkId());
        }
        JSONObject map =  JSONObject.parseObject(body);
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        QueryWrapper<Works> worksWrapper = new QueryWrapper<>();
        worksWrapper.in("id",workIdList);
        queryWrapper.orderByDesc("create_time");
        IPage<Works> iPage = new Page<>(pageNo,pageSize) ;
        IPage<Works> page = worksService.page(iPage, worksWrapper);
        return ResponseUtils.success(page.getRecords());
    }

    /**
     * 我的作品
     * @param body
     * @return
     */
    @RequestMapping("myWork")
    public R<?> myWork(@RequestBody String body){
        JSONObject map =  JSONObject.parseObject(body);
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        QueryWrapper<Works> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id",TokenUtil.getTokenUserId());
        queryWrapper.orderByDesc("create_time");
        IPage<Works> iPage = new Page<>(pageNo,pageSize);
        IPage<Works> page = worksService.page(iPage,queryWrapper);
        List<Works> list = page.getRecords();
        return ResponseUtils.success(list);
    }

    /**
     * 查询作品
     * @param id
     * @return
     */
    @RequestMapping(value = "getById")
    public R<?> getById(Long id){
        Works works = worksService.getById(id);
        Long userId = TokenUtil.getTokenUserId();
        CustomerUser customerUser = customerUserService.getById(works.getCreateUserId());
        works.setUsername(customerUser.getUsername());
        works.setHeadPortrait(customerUser.getHeadPortrait());
        //查询作品是否被点赞
        QueryWrapper<Fabulous> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("work_id",id);
        queryWrapper.eq("create_user_id",userId);
        int count = fabulousService.count(queryWrapper);
        if(count > 0){
            works.setLike(true);
        }
        //查询作品是否被收藏
        QueryWrapper<WorkCollection> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("work_id",id);
        queryWrapper1.eq("create_user_id",userId);
        int count1 = collectionService.count(queryWrapper1);

        if(count1 > 0){
            works.setConcern(true);
        }
        if(works.getCreateUserId() == userId ){
            works.setOneseif(true);
        }
        //查询作品的用户是否被当前用户关注
        QueryWrapper<Follow> query = new QueryWrapper<>();
        query.eq("user_id",works.getCreateUserId());
        query.eq("create_user_id",TokenUtil.getTokenUserId());
        int follow = followService.count(query);
        if(follow > 0){
            works.setFollow(true);
        }
        List<Works> list = new ArrayList<>();
        list.add(works);
        return ResponseUtils.success(list);
    }

    /**
     * 查询作品列表
     * @param body
     * @return
     */
    @RequestMapping(value = "list")
    public R<?> list(@RequestBody String body){
        JSONObject map =  JSONObject.parseObject(body);
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        QueryWrapper<Works> queryWrapper = new QueryWrapper<>();

        int workType = Integer.parseInt(map.get("workType").toString());
        Long userId = Long.parseLong(map.get("userId").toString());
        if(userId == 0l){
            if(workType == 0){//查询我的作品
                queryWrapper.eq("create_user_id",TokenUtil.getTokenUserId());
            }else {//查询分类作品
                queryWrapper.eq("work_type",workType);
            }
        }else{//按用户id查询
            queryWrapper.eq("create_user_id",userId);
        }

        queryWrapper.orderByDesc("create_time");
        IPage<Works> iPage = new Page<>(pageNo,pageSize);
        IPage<Works> page = worksService.page(iPage,queryWrapper);
        List<Works> list = page.getRecords();
        return ResponseUtils.success(list);
    }

    /**
     * 添加作品
     * @param body
     * @return
     */
    @RequestMapping(value = "save")
    public R<?> save(@RequestBody String body){
        JSONObject json =  JSONObject.parseObject(body);
        Works works = JSON.toJavaObject(json, Works.class);
        works.setCreateUserId(TokenUtil.getTokenUserId());
        worksService.save(works);
        return  ResponseUtils.success();
    }

    /**
     * 删除作品
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    public R<?> delete(Long id){
         worksService.removeById(id);
        return  ResponseUtils.success();
    }
}
