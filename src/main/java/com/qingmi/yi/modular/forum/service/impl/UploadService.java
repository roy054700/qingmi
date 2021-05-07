package com.qingmi.yi.modular.forum.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 上传文件
 * @Author: 李龙真
 * @Date: 2021/5/6 15:05
 */
@Service
@Transactional
public class UploadService {
    public final String accessKey = "Vhjh0XRgotT7dK_AI42FpOSiH13CMtavi5GRwGvG";
    private final String secretKey = "aBBezAHqd6NFiyhevubRyHogpIVkLqcUnBtSYkUe";
    private final String bucket = "qingmi-mary";

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);


    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    //获取token
    public String getToken(){
        Auth auth = Auth.create(accessKey,secretKey);
        return auth.uploadToken(bucket);
    }


    public void upload(byte[] data,String key) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(data, key, getToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
}
