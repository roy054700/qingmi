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
import com.qingmi.yi.modular.forum.model.Comment;
import com.qingmi.yi.modular.forum.model.CustomerUser;
import com.qingmi.yi.modular.forum.service.CommentService;
import com.qingmi.yi.modular.forum.service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 评论
 * @Author: 李龙真
 * @Date: 2021/3/11 13:52
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CustomerUserService customerUserService;

    /**
     * 查询某个作品的评论
     * @param id 作品id
     * @return
     */
    @RequestMapping(value = "/list")
    public R<?> list(Long id){
        IPage<Comment> page = new Page<>(0,10);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("work_id",id);
        queryWrapper.eq("parent_id",0);
        queryWrapper.orderByDesc("create_time");
        List<Comment> list = commentService.page(page,queryWrapper).getRecords();
        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                CustomerUser customerUser = customerUserService.getById(list.get(i).getCreateUserId());
                list.get(i).setHeadPortrait(customerUser.getHeadPortrait());
                list.get(i).setUsername(customerUser.getUsername());
            }
        }
        return ResponseUtils.success(list);
    }

    /**
     * 查询全部评论，父子结构
     * @param bady
     * @return
     */
    @RequestMapping(value = "/pageList")
    public R<?> pageList(@RequestBody String bady){
        JSONObject map =  JSONObject.parseObject(bady);
        Long workId = Long.parseLong(map.get("workId").toString());
        if(workId == 0l){
            return answerList(map);
        }else{
            return commentList(map);
        }
    }

    /**
     * 查询某个作品全部评论，父子结构
     * @param map
     * @return
     */
    public R<?> commentList(JSONObject map){
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        String workId = map.get("workId").toString();
        IPage<Comment> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("work_id",workId);
        queryWrapper.eq("parent_id",0);
        queryWrapper.orderByDesc("create_time");
        List<Comment> list = commentService.page(page,queryWrapper).getRecords();
        List<Comment> pageList = new ArrayList<>();
        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                pageList.add(list.get(i));
                QueryWrapper<Comment> query = new QueryWrapper<>();
                query.eq("parent_id",list.get(i).getId());
                List<Comment> list1 = commentService.list(query);
                if(list1 != null) {
                    pageList.addAll(list1);
                }
            }
            for (int i = 0; i < pageList.size(); i++) {
                CustomerUser customerUser = customerUserService.getById(pageList.get(i).getCreateUserId());
                pageList.get(i).setUsername(customerUser.getUsername());
                pageList.get(i).setHeadPortrait(customerUser.getHeadPortrait());
            }
        }
        return ResponseUtils.success(pageList);
    }

    /**
     * 查询我的评论，某人发布的评论
     * @param map
     * @return
     */
    public R<?> answerList(JSONObject map){
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        IPage<Comment> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Comment> query = new QueryWrapper<>();
        query.eq("create_user_id",TokenUtil.getTokenUserId());
        query.eq("parent_id",0);
        query.orderByDesc("create_time");
        //查询我发布的评论
        List<Comment> answerList = new ArrayList<>();
        IPage<Comment> page1 = commentService.page(page, query);
        List<Comment> list = page1.getRecords();
        if(list != null && list.size()>0){
            for(int i=0;i<list.size();i++){
                Comment comment = list.get(i);
                answerList.add(comment);
                query = new QueryWrapper<>();
                query.eq("parent_id",comment.getId());
                answerList.addAll(commentService.list(query));
            }
            //添加用户信息
            for (int i = 0; i < answerList.size(); i++) {
                CustomerUser customerUser = customerUserService.getById(answerList.get(i).getCreateUserId());
                answerList.get(i).setUsername(customerUser.getUsername());
                answerList.get(i).setHeadPortrait(customerUser.getHeadPortrait());
            }

        }
        return ResponseUtils.success(answerList);


    }
    /**
     * 添加评论
     * @param param
     * @return
     */
    @RequestMapping(value = "/save")
    public R<?> save(@RequestBody String param){
        JSONObject json =  JSONObject.parseObject(param);
        Comment comment = JSON.toJavaObject(json, Comment.class);

        comment.setCreateUserId(TokenUtil.getTokenUserId());
        boolean b = commentService.save(comment);
        return  ResponseUtils.success();
    }

}
