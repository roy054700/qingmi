package com.qingmi.yi.modular.news.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
/**
 * 新闻图片表
 *
 * @author FCHEN
 * @version 1.0 2020-01-20
 */
@TableName("final_news_picture")
public class FinalNewsPicture extends Model<FinalNewsPicture> {

    /**
     * id
     */
    private Long id;

    /**
     * 新闻id
     */
    private Long contentId;
    /**
     * 新闻图片地址
     */
    private String url;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return id;
    }
}