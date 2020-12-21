package com.qingmi.yi.common.enums;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * 公共枚举
 *
 */
public enum CommonEnum {

    /**
     * 任务场景
     */
    TASK_SCENES_COMPLETE_MATERIAL("完善个人资料", "TASK_SCENES", 1),
    TASK_SCENES_RECORD_BLOOD_PRESSURE("记录血压", "TASK_SCENES", 4),
    TASK_SCENES_RECORD_BLOOD_SUGAR("记录血糖", "TASK_SCENES", 5),
    TASK_SCENES_CHECK_IN("每日签到", "TASK_SCENES", 8),
    ;

    @Getter
    private String name;

    @Getter
    private String code;

    @Getter
    private Integer value;

    CommonEnum(String name, String code, Integer value) {
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public static List<CommonEnum> getEnumList(String code) {
        List<CommonEnum> list = Lists.newArrayList();
        for (CommonEnum type : CommonEnum.values()) {
            if (type.getCode().equals(code)) {
                list.add(type);
            }
        }
        return list;
    }

    public static String getLabel(String code, String value) {
        List<CommonEnum> enumList = getEnumList(code);
        String valueLabel = "";
        for (CommonEnum sysDictEnum : enumList) {
            if (sysDictEnum.getValue().equals(Integer.valueOf(value))) {
                valueLabel = sysDictEnum.getName();
                break;
            }
        }
        return valueLabel;
    }
}
