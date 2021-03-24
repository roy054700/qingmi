package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 作品点赞
 * @Author: 李龙真
 * @Date: 2021/3/10 11:26
 */
@Data
@TableName("o_fabulous")
public class Fabulous {
    private Long id;//主键',
    private Long workId;//作品id',
    private Long createUserId;//创建人id',
    private Date createTime;
}
