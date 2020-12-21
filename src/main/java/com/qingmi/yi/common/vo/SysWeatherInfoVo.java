package com.qingmi.yi.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author cx
 * @Date 2019-10-28 14:58:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysWeatherInfoVo implements Serializable {
    //主键
    private String id;

    //当前日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date currentDate;

    //当前温度
    private String temperature;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //天气图
    private String weatcherImg;

    //天气状况
    private String weatcherDesc;

    //城市名称
    private String cityName;

    //城市id
    private String cityId;

}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
