
package com.qingmi.yi.modular.news.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 新闻标签表
 *
 * @author roy
 * @version 1.0 2020-05-02
 */
@TableName("news_label")
public class NewsLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标签名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}