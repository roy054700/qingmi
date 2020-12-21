package com.qingmi.yi.common.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @className GyNewsScenes
 * @description: 消息场景
 * @date 2019-10-28 17:42
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GyNewsScenes implements Serializable {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String sceneCode;
    /**
     * 场景名称
     */
    private String sceneName;
    /**
     * 场景内容
     */
    private String sceneContent;
    /**
     * 消息场景类型
     */
    private Integer sceneType;
    /**
     * 消息类型
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;

    private String createBy;

    private Date createTime;
}
