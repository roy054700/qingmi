package com.qingmi.yi.common.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qingmi.yi.common.enums.SysDictEnum;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 用户账户余额记录表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysUserAccountAmountRecordsVO implements Serializable {
    private String id;

    //标题
    private String title;

    //记录类型
    private Integer recordType;

    //记录类型字典码
    private String recordTypeCode;

    //金额
    private BigDecimal amount;

    //余额
    private BigDecimal balanceAmount;

    //用户
    private String userId;

    //摘要
    private String content;

    //创建人
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //数据状态
    private Integer status;

    @Getter
    public Integer getStatus() {
        if (status == null) {
            status = SysDictEnum.DATA_STATUS_ENABLE.getValue();
        }
        return status;
    }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
