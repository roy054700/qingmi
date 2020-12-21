package com.qingmi.yi.common.vo;

import lombok.Data;

@Data
public class PayConfigVo {
    //编号
    private String id;
    //支付方式(SysDictEnum-PAY-CONFIG 1、微信移动支付 2、微信小程序支付 3、支付宝支付)
    private Integer payType;
    //支付方式名称
    private String payTypeName;
    //商户号
    private String mchId;
    //appid
    private String appId;
    //密钥(api key)
    private String secretKey;
    //支付宝合作伙伴id
    private String partner;
    //支付宝卖家账号
    private String account;
    //商户私钥
    private String rsaPrivate;
    //商户公钥
    private String rsaPublic;
}
