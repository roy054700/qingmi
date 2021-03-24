package com.qingmi.yi.modular.forum.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 关注
 * @Author: 李龙真
 * @Date: 2021/3/12 15:59
 */
@Data
@TableName("o_follow")
public class Follow {
    private Long id;//主键',
    private Long userId;//作品id',
    private Long createUserId;//创建人id',
    private Date createTime;
}
