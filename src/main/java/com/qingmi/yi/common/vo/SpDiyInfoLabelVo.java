package com.qingmi.yi.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class SpDiyInfoLabelVo {

    //标签ID
    private String groupId;

    //标签名称
    private String groupName;

    //排序
    private Integer sort;

    private String  createBy;

    private String createTime;

    private String optionId;

    private String optionName;

    private Integer optionSort;

    private String optionIcon;

    private List<SpDiyInfoLabelVo> options = new ArrayList<>();
}
