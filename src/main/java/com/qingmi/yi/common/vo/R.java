package com.qingmi.yi.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain =true)
public class R<T>  implements Serializable {
    /**
     * 消息
     */
    private String message;
    /**
     * 请求状态码
     */
    private Integer code = 200;
    /**
     * 请求时间
     */
    private long timestamp=System.currentTimeMillis();
    /**
     * 返回结果
     */
    private T data;
}
