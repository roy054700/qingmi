package com.qingmi.yi.modular.news.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingmi.yi.common.utils.Constants;
import com.qingmi.yi.common.utils.HttpClientUtils;
import com.qingmi.yi.modular.news.dao.FinalNewsContentMapper;
import com.qingmi.yi.modular.news.dao.FinalNewsPictureMapper;
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
    @Autowired
    FinalNewsPictureMapper finalNewsPictureMapper;

    @Override
    public List<FinalNewsContent> selectPage(Page<FinalNewsContent> page, FinalNewsContent model,String top) {
        List<FinalNewsContent> list = finalNewsContentMapper.selectPage(page, model);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                FinalNewsContent con = list.get(i);
                QueryWrapper<FinalNewsPicture> ew = new QueryWrapper<FinalNewsPicture>();
                ew.eq("content_id", con.getContentId());
                List<FinalNewsPicture> picList = finalNewsPictureMapper.selectList(ew);
                con.setPicList(picList);
            }
        }else {
            return list;
        }
        //list.addAll(0,getTopContent(top));
        return getList(list,getTopContent(top));
    }

    /**
     * 5条广告
     * 在 list 中间隔五个元素插入一条 topList 里面的数据
     * @param list
     * @param topList
     * @return
     */
    private List<FinalNewsContent> getList(List<FinalNewsContent> list,List<FinalNewsContent> topList){
        int num = list.size()/Constants.TOP_SIZE;
       for(int i=0;i<num;i++){
           if(i==num){
               list.add(topList.get(i));
           }else {
               int index = (i + 1) * 6 - 1;
               list.add(index, topList.get(i));
           }
       }
        return list;
    }




    /**
     * 根据手机参数 使用http 获取广告信息
     * @param json
     * @return
     */
    public List<FinalNewsContent> getTopContent(String json) {
        JSONArray jsonArray = JSONArray.parseArray(json);
        List<FinalNewsContent> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = HttpClientUtils.httpPost(Constants.TOP_URL, jsonArray.getJSONObject(i).toJSONString());
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
        cnt.setTop(true);
        return cnt;


    }







    public static void main(String[] args) {

    }
}
