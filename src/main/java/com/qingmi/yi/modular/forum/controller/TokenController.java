package com.qingmi.yi.modular.forum.controller;

import com.qingmi.yi.common.utils.ResponseUtils;
import com.qingmi.yi.common.vo.R;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取token
 * @Author: 李龙真
 * @Date: 2021/5/6 12:38
 */
@RestController
@RequestMapping("/upload")
public class TokenController {
    public final String accessKey = "Vhjh0XRgotT7dK_AI42FpOSiH13CMtavi5GRwGvG";
    private final String secretKey = "aBBezAHqd6NFiyhevubRyHogpIVkLqcUnBtSYkUe";
    private final String bucket = "qingmi-mary";

    @RequestMapping(value = "/getToken")
    public R<?> getToken(){
        Auth auth = Auth.create(accessKey,secretKey);
        Object uploadToken = auth.uploadToken(bucket);
        return ResponseUtils.success(uploadToken);
    }
}
