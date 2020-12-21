package com.qingmi.yi.common.dto;

import com.qingmi.yi.common.utils.ObjectUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Map;

/**
 * @author : hugd
 * @project_name: sparrow
 * @date: 2019-04-17 11:04
 */
@Data
@Accessors(chain = true)
public class LogDTO {

    private String name;

    private Integer logType;

    private String requestUrl;

    private String requestType;

    private String requestParam;

    private String username;

    private String ip;

    private String ipInfo;

    private Integer costTime;

    private Date createTime;

    private String createBy;
    /**
     * 转换请求参数为Json
     * @param paramMap
     */
    public void setMapToParams(Map<String, String[]> paramMap) {

        this.requestParam = ObjectUtil.mapToString(paramMap);
    }
}
