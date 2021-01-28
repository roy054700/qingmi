package com.qingmi.yi.modular.news.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.modular.news.model.FinalNewsContent;
import com.qingmi.yi.modular.news.model.FinalNewsPicture;
import com.qingmi.yi.modular.news.model.NewsLabel;
import com.qingmi.yi.modular.news.service.FinalNewsContentService;
import com.qingmi.yi.modular.news.service.FinalNewsPictureService;
import com.qingmi.yi.modular.news.service.NewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.alibaba.druid.util.StringUtils;

/**
 * 最终使用的新闻控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/news/final")
public class FinalNewsContentController extends BaseController {


    @Autowired
    private FinalNewsPictureService finalNewsPictureService;
    @Autowired
    private FinalNewsContentService finalNewsContentService;

    /**
     * app客户端访问数据,分页查询
     * @param pageNo 页码
     * @param pageSize 条数
     * @param model 分类参数
     * @param top 广告参数
     * @return
     */
    @RequestMapping(value = "/appList")
    @ResponseBody
    public ResponseEntity<?> appList(Integer pageNo, Integer pageSize,FinalNewsContent model,String top) {
        System.out.print(model.toString());
        List<FinalNewsContent> list = finalNewsContentService.selectPage(new Page<>(pageNo, pageSize), model,top);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                FinalNewsContent con = list.get(i);
                QueryWrapper<FinalNewsPicture> ew = new QueryWrapper<FinalNewsPicture>();
                ew.eq("content_id", con.getContentId());
                List<FinalNewsPicture> picList = finalNewsPictureService.list(ew);
                con.setPicList(picList);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "ok");
        map.put("newList", list);
        return ResponseEntity.ok(map);
    }

    /**
     * app查询数据详情
     */
    @RequestMapping(value = "/appFindByid")
    @ResponseBody
    public ResponseEntity<?> appFindByid(Long id) {
        FinalNewsContent con = finalNewsContentService.getById(id);//查询数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "ok");
        map.put("details", con);
        return ResponseEntity.ok(map);
    }




}
