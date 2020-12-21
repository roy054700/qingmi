package com.qingmi.yi.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 冷言丶冷语
 * @className MessageTemplate
 * @description
 * @date 2019-10-31 11:45
 **/
@Data
public class MessageTemplate implements Serializable {
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 模板编码
     */
    private String templateCode;
    /**
     * 标题
     */
    private String title;
    /**
     * 模板内容
     */
    private String content;



    private Integer status;
}
