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
import com.qingmi.yi.modular.forum.service.CollectionService;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import com.qingmi.yi.modular.forum.service.FabulousService;
import com.qingmi.yi.modular.forum.service.WorksService;
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
        CustomerUser customerUser = customerUserService.getById(works.getCreateUserId());
        works.setUsername(customerUser.getUsername());
        works.setHeadPortrait(customerUser.getHeadPortrait());
        //查询作品是否被点赞
        QueryWrapper<Fabulous> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("work_id",id);
        List<Fabulous> list1 = fabulousService.list(queryWrapper);
        if(list1 != null && list1.size() > 0){
            works.setLike(true);
        }
        //查询作品是否被收藏
        QueryWrapper<WorkCollection> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("work_id",id);
        List<WorkCollection> list2 = collectionService.list(queryWrapper1);
        if(list2 != null && list2.size() > 0){
            works.setConcern(true);
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
        queryWrapper.eq("work_type",Integer.parseInt(map.get("workType").toString()));
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
        works.setCreateUserId(1l);
//        works.setCreateUserId(TokenUtil.getTokenUserId());
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
