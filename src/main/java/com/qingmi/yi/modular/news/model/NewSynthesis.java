package com.qingmi.yi.modular.news.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻综合推荐列表
 *
 * @author FCHEN
 * @version 1.0 2020-01-20
 */
public class NewSynthesis implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 新闻id
     */
    private Long contentId;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 来源
     */
    private String source;
    /**
     * 新闻简介
     */
    private String contentInfo;
    /**
     * 新闻地址
     */
    private String url;
    /**
     * 新闻时间
     */
    private Date contentTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo == null ? null : contentInfo.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}