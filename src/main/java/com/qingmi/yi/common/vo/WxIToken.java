package com.qingmi.yi.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxIToken implements Serializable {

    @JsonIgnore
    private String access_token;

    @JsonIgnore
    private Long expires_in;

    private String openid;

    // 是否绑定手机号 1已绑定 2未绑定
    private String isBindMobile;

    @JsonIgnore
    private String scope;

    @JsonIgnore
    private String refresh_token;
}
