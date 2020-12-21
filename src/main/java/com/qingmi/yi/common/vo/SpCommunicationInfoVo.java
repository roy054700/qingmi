package com.qingmi.yi.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class SpCommunicationInfoVo implements Serializable {

    private String id;

    private String communicationName;

    private String communicationType;

    private Integer sort;

    private String  createBy;

    private String createTime;

    private String optionId;

    private String optionName;

    private Integer optionSort;

    private Integer index;

    private List<SpCommunicationInfoVo> options = new ArrayList<>();
}
