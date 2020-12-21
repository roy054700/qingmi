package com.qingmi.yi.modular.news.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 新闻内容表
 *
 * @author FCHEN
 * @version 1.0 2020-01-20
 */
@TableName("sensitiveness_tab")
public class NewContent implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 新闻id
     */
    private Long contentId;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}