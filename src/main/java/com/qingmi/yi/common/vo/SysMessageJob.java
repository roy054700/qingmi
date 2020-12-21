package com.qingmi.yi.common.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 消息任务表
 *
 * @author cx
 * @Date 2019-12-27 13:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysMessageJob implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    //消息任务
    private String jobTaskName;

    //消息任务类型1:短信  2：消息
    private Integer jobTaskType;

    //消息任务状态:1进行中 2：暂停 3:已完成:4作废
    private Integer jobTaskState;

    //创建人
    private String createBy;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //消息任务发送时间
    private Date jobSendTime;

    //消息任务失效时间
    private Date jobExpireTime;

    //消息任务接收人
    private String jobReceiptUser;

    //消息任务内容
    private String jobTaskContent;

    //消息任务内容参数
    private String jobTaskParams;

    //消息任务模板code
    private String jobTemplateCode;

    //消息任务发送次数
    private Integer jobSendNum;

    //消息任务发送已发送次数
    private Integer jobAlreadySendNum;


}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
