package com.qingmi.yi.modular.news.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 广告实体
 *
 * @author Administrator
 */
@TableName("news_top")
public class NewsTop extends Model<NewsTop> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long oid;
    private Integer category;//分类 轮播图广告：0,首页广告：1
    private String photo;//图片路径
    private String subject;
    private String url;
    private Integer state;//状态 关闭 ：0，打开：1
    private Date createdTime;
    private String createdUserId;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the oid
     */
    public Long getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }

    /**
     * @return the category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return the createdtime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return the createdUserId
     */
    public String getCreatedUserId() {
        return createdUserId;
    }

    /**
     * @param createdUserId the createdUserId to set
     */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NewsTop [id=" + id + ", oid=" + oid + ", category=" + category + ", photo=" + photo + ", subject="
                + subject + ", url=" + url + ", state=" + state + ", createdTime=" + createdTime + ", createdUserId="
                + createdUserId + "]";
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
