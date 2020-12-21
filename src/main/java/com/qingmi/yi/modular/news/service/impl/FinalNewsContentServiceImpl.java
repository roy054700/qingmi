package com.qingmi.yi.modular.news.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.news.dao.FinalNewsContentMapper;
import com.qingmi.yi.modular.news.model.FinalNewsContent;
import com.qingmi.yi.modular.news.service.FinalNewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalNewsContentServiceImpl extends ServiceImpl<FinalNewsContentMapper, FinalNewsContent> implements FinalNewsContentService {

    @Autowired
    private FinalNewsContentMapper finalNewsContentMapper;

    @Override
    public List<FinalNewsContent> selectPage(Page<Map<Object, Object>> page, FinalNewsContent model) {
        return finalNewsContentMapper.selectPage(page, model);
    }


}
