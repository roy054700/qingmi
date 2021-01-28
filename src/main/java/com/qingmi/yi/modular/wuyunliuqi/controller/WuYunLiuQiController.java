package com.qingmi.yi.modular.wuyunliuqi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.utils.WuLiuUtils;
import com.qingmi.yi.common.vo.R;
import com.qingmi.yi.modular.wuyunliuqi.model.TianGanDiZhi;
import com.qingmi.yi.modular.wuyunliuqi.model.WuYunLiuQi;
import com.qingmi.yi.modular.wuyunliuqi.service.TianGanDiZhiService;
import com.qingmi.yi.modular.wuyunliuqi.service.WuYunLiuQiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 李龙真
 * @Date: 2020/12/27 13:34
 */
@RestController
@RequestMapping("/wuyunliuqi")
public class WuYunLiuQiController  {

    @Autowired
    public WuYunLiuQiService wuYunLiuQiService;
    @Autowired
    public TianGanDiZhiService tianGanDiZhiService;

    /**
     * 根据当前年份
     * 获取该季节五运六气
     * @return
     */
    @RequestMapping("/getWuLiu")
    public R<?> getWuLiu(String date) {
        List<WuYunLiuQi> list = new ArrayList<>();
        QueryWrapper<TianGanDiZhi> tianGanDiZhiQueryWrapper = new QueryWrapper<>();
        tianGanDiZhiQueryWrapper.eq("name",WuLiuUtils.getGanZhi(date));
        int tianId=tianGanDiZhiService.getOne(tianGanDiZhiQueryWrapper).getId();;//计算天干地支id
        int wuOrder=WuLiuUtils.getWuYun(date);//五运的编号
        int liuOrder=WuLiuUtils.getLiuQi(date);//六气的编号
        QueryWrapper<WuYunLiuQi> wrapper = new QueryWrapper<>();
        wrapper.eq("tian_id", tianId).eq("sort", wuOrder).eq("type",1);
        //查询五运 1 为五运；
        WuYunLiuQi wu = wuYunLiuQiService.getOne(wrapper);

        QueryWrapper<WuYunLiuQi> liuQiQueryWrapper = new QueryWrapper<>();
        liuQiQueryWrapper.eq("tian_id", tianId).eq("sort", liuOrder).eq("type",2);
        //查询六气 type 2为六气
        WuYunLiuQi liu = wuYunLiuQiService.getOne(liuQiQueryWrapper);
        list.add(wu);
        list.add(liu);
        return ResponseUtils.success(list);
    }


}
