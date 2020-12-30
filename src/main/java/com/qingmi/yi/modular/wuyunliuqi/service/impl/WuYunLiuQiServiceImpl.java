package com.qingmi.yi.modular.wuyunliuqi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.wuyunliuqi.mapper.WuYunLiuQiMapper;
import com.qingmi.yi.modular.wuyunliuqi.model.WuYunLiuQi;
import com.qingmi.yi.modular.wuyunliuqi.service.WuYunLiuQiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 李龙真
 * @Date: 2020/12/27 13:31
 */
@Service
@Transactional
public class WuYunLiuQiServiceImpl extends ServiceImpl<WuYunLiuQiMapper, WuYunLiuQi> implements WuYunLiuQiService {
}