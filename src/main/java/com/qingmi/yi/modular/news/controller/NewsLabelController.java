package com.qingmi.yi.modular.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.base.BaseController;
import com.qingmi.yi.modular.news.model.NewsLabel;
import com.qingmi.yi.modular.news.service.NewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/news/label")
public class NewsLabelController extends BaseController {

    @Autowired
    private NewsLabelService newsLabelService;

    /**
     * 分类
     */
    @RequestMapping(value = "/category")
    @ResponseBody
    public ResponseEntity<?> category() {
        //查询分类标签
        //List<Dict> list = dictMapper.selectList(new EntityWrapper<Dict>().eq("pid", 282));
        List<NewsLabel> list = newsLabelService.list(new QueryWrapper<NewsLabel>());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "ok");
        map.put("category", list);
        return ResponseEntity.ok(map);
    }


}
