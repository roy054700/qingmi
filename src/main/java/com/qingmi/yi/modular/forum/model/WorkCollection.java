package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 作品收藏
 * @Author: 李龙真
 * @Date: 2021/3/10 11:24
 */
@Data
@TableName("o_collection")
public class WorkCollection {

    private Long id;//主键',
    private Long workId;//作品id',
    private Long createUserId;//创建人id',
    private Date createTime;
}
