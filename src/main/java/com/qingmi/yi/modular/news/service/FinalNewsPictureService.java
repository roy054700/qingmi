package com.qingmi.yi.modular.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingmi.yi.modular.news.model.FinalNewsPicture;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface FinalNewsPictureService extends IService<FinalNewsPicture> {

}
