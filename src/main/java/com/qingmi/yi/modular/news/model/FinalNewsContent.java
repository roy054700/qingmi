package com.qingmi.yi.modular.news.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 新闻表
 *
 * @author FCHEN
 * @version 1.0 2020-01-20
 */
@Data
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
    private boolean top = false;//是否是广告 是 true ,否 false

    @TableField(exist = false)
    private boolean focus = false;//是否是轮播图广告 是 true ,否 false
    /**
     * 广告跳转链接
     */
    @TableField(exist = false)
    private String url;

    @TableField(exist = false)
    private List<FinalNewsPicture> picList;
    //点击跳转监播链接
    @TableField(exist = false)
    private String[] clickUrls;




}
