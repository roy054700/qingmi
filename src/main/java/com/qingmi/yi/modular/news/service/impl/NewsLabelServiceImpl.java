package com.qingmi.yi.modular.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.news.dao.NewsLabelMapper;
import com.qingmi.yi.modular.news.model.NewsLabel;
import com.qingmi.yi.modular.news.service.NewsLabelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 新闻标签
 *
 * @author Administrator
 */
@Service
@Transactional
public class NewsLabelServiceImpl extends ServiceImpl<NewsLabelMapper, NewsLabel> implements NewsLabelService {


}
