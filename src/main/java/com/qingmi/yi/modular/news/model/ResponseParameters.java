package com.qingmi.yi.modular.news.model;

import lombok.Data;

/**
 * 广告接口响应参数
 */
@Data
public class ResponseParameters {
    public String requestId	;//	对应请求的ID
    public String adid	;//	广告位ID
    public String returnCode	;//	返回标识CODE（见文档以下code枚信息8.1）
    public String returnMsg	;//	返回信息

    public Ads ads;//子元素


}
