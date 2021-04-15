package com.qingmi.yi.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 李龙真
 * @Date: 2021/4/14 16:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "shortmmessage")
public class ShortMmessage {

    public String secretId;
    public String secretKey;
    public String endpoint;
    public String templateID;
    public String sign;
    public String smsSdkAppid;

}
