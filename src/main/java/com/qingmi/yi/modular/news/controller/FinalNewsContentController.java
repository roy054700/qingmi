package com.qingmi.yi.modular.news.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
import org.springframework.web.bind.annotation.RequestBody;
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
    private FinalNewsContentService finalNewsContentService;


    @RequestMapping(value = "/list")
    @ResponseBody
    public ResponseEntity<?> list(@RequestBody String json) {

        JSONObject map =  JSONObject.parseObject(json);
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        String source = map.get("source").toString();
        String top = map.get("top").toString();

        FinalNewsContent fnc = new FinalNewsContent();
        fnc.setSource(source);
        Page<FinalNewsContent> page = new Page<>(pageNo, pageSize);
        List<FinalNewsContent> list = finalNewsContentService.selectPage(page, fnc,top);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("code", "ok");
        map1.put("newList", list);
        return ResponseEntity.ok(map1);
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
