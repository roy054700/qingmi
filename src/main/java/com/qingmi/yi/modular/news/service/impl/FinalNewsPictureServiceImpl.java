package com.qingmi.yi.modular.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.news.dao.FinalNewsPictureMapper;
import com.qingmi.yi.modular.news.model.FinalNewsPicture;
import com.qingmi.yi.modular.news.service.FinalNewsPictureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class FinalNewsPictureServiceImpl extends ServiceImpl<FinalNewsPictureMapper, FinalNewsPicture> implements FinalNewsPictureService {

}
