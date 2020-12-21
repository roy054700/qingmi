package com.qingmi.yi.modular.news.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 新闻表
 *
 * @author FCHEN
 * @version 1.0 2020-01-20
 */
@TableName("final_news_content")
public class FinalNewsContent extends Model<FinalNewsContent> {
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
     * 新闻内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private List<FinalNewsPicture> picList;

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


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return this.id;
    }

    /**
     * @return the picList
     */
    public List<FinalNewsPicture> getPicList() {
        return picList;
    }

    /**
     * @param picList the picList to set
     */
    public void setPicList(List<FinalNewsPicture> picList) {
        this.picList = picList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FinalNewsContent [id=" + id + ", contentId=" + contentId + ", title=" + title + ", source=" + source
                + ", contentInfo=" + contentInfo + ", content=" + content + ", createTime=" + createTime + ", picList="
                + picList + "]";
    }

}
