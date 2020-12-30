package com.qingmi.yi.modular.wuyunliuqi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.modular.wuyunliuqi.mapper.TianGanDiZhiMapper;
import com.qingmi.yi.modular.wuyunliuqi.model.TianGanDiZhi;
import com.qingmi.yi.modular.wuyunliuqi.service.TianGanDiZhiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 李龙真
 * @Date: 2020/12/28 17:24
 */
@Service
@Transactional
public class TianGanDiZhiServiceImpl extends ServiceImpl<TianGanDiZhiMapper, TianGanDiZhi> implements TianGanDiZhiService {
}
