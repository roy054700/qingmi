package com.qingmi.yi.modular.news.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.common.utils.Constants;
import com.qingmi.yi.common.utils.HttpClientUtils;
import com.qingmi.yi.modular.news.dao.FinalNewsContentMapper;
import com.qingmi.yi.modular.news.model.Ads;
import com.qingmi.yi.modular.news.model.FinalNewsContent;
import com.qingmi.yi.modular.news.model.FinalNewsPicture;
import com.qingmi.yi.modular.news.model.ResponseParameters;
import com.qingmi.yi.modular.news.service.FinalNewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalNewsContentServiceImpl extends ServiceImpl<FinalNewsContentMapper, FinalNewsContent> implements FinalNewsContentService {

    @Autowired
    private FinalNewsContentMapper finalNewsContentMapper;

    @Override
    public List<FinalNewsContent> selectPage(Page<Map<Object, Object>> page, FinalNewsContent model,String top) {
        List<FinalNewsContent> list = finalNewsContentMapper.selectPage(page, model);
        list.addAll(0,getTopContent(top));
        return list;
    }

    /**
     * 根据手机参数 使用http 获取广告信息
     * @param top
     * @return
     */
    public List<FinalNewsContent> getTopContent(String top) {
        List<FinalNewsContent> list = new ArrayList<>();
        String[] split = top.split("|");
        for(int i = 0; i < split.length; i++){
            JSONObject jsonObject = HttpClientUtils.httpPost(Constants.TOP_URL, split[i]);
            FinalNewsContent fnc = jsonToModel(jsonObject);
            list.add(fnc);
        }
        return list;
    }

    /**
     * 将json 转换成实体对象
     * @param json
     * @return
     */
    private FinalNewsContent jsonToModel(JSONObject json){
        ResponseParameters parameter = new ResponseParameters();
        try {
            JSONObject jsonObject = new JSONObject(json);
            String returnCode = jsonObject.get("returnCode").toString();
            parameter.setReturnCode(returnCode);
            if(!returnCode.equals("1000")){//不成功
                return null;
            }else {
                JSONArray list = jsonObject.getJSONArray("ads");
                JSONObject object = list.getJSONObject(0);
                Ads ads = JSON.parseObject(object.toString(), Ads.class);
                parameter.setAds(ads);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return getTop(parameter.getAds());
    }

    public static FinalNewsContent getTop(Ads ads){
        String url = ads.getClickurl();
        if(ads.getDeepLink() != null && ads.getDeepLink().length() > 0){
            url = ads.getDeepLink();
        }
        FinalNewsContent cnt = new FinalNewsContent();
        FinalNewsPicture pic = new FinalNewsPicture();
        List<FinalNewsPicture> list = new ArrayList<>();
        pic.setUrl(ads.getImgurls()[0]);
        list.add(pic);
        cnt.setPicList(list);
        cnt.setTitle(ads.getDisplayTitle());
        cnt.setUrl(url);
        return cnt;


    }















    public static void main(String[] args) {

    }
}
