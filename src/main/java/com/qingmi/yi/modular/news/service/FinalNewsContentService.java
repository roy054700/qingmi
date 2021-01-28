package com.qingmi.yi.modular.news.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qingmi.yi.modular.news.model.FinalNewsContent;

import java.util.List;
import java.util.Map;

public interface FinalNewsContentService extends IService<FinalNewsContent> {

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     */
    List<FinalNewsContent> selectPage(Page<Map<Object, Object>> page, FinalNewsContent model,String top);


}
