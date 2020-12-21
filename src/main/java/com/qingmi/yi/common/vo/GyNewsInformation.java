package com.qingmi.yi.common.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qingmi.yi.common.enums.SysDictEnum;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @className GyNewsInfomation
 * @description
 * @date 2019-10-29 9:42
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class GyNewsInformation implements Serializable {

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息类型
     */
    private Integer messageType;
    /**
     * 消息类型字典码
     */
    private String messageTypeCode;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 消息状态 已读 未读
     */
    private Integer state;

    private String stateCode;
    /**
     * 消息场景id
     */
    private String messageSceneId;
    /**
     * 接收者
     */
    private String receiveName;
    /**
     * 接收者id
     */
    private String receiveId;
    /**
     * 发送者id
     */
    private String sendId;
    /**
     * 发送者名称
     */
    private String sendName;
    @TableField(exist = false)
    private String sceneName;

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }
}
