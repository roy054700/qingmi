package com.qingmi.yi.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WxUserInfo  implements Serializable {

    private String openid;

    private String nickname;

    private Integer sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String unionid;
}
