package com.qingmi.yi.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 短信日志传输对象
 * </p>
 * @author 胡国栋
 */
@Data
@Accessors(chain = true)
public class SmsLogDTO {

    private String mobile;

    private String content;

    private String smsType;

    private String formPlat;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date sendDate;

}
