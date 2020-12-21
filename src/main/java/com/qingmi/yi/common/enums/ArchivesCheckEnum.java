package com.qingmi.yi.common.enums;

import lombok.Getter;

/**
 * 健康档案新增编辑校验
 *
 */
public enum ArchivesCheckEnum {

    /**
     * 档案新增编辑校验场景
     */
    YES("校验通过",   100),
    PHONE("手机号码重复，请检查手机号码填写是否有误！",   101),
    ID_CARD("身份证号码重复，请检查身份证号码填写是否有误！",   102),
    ONESELF("本人已经存在档案！",   103),
    ONESELF_LINK("身份证已存在档案，本人已被其他用户关联为亲友档案，请选择关联！",   104),
    FRIEND_LINK("身份证已存在档案，该亲友已被其他用户关联为亲友档案，请选择关联！",   105),
    POWER("该档案创建人不是本人，您没有修改权限，如需修改请联系档案创建人！",   106);

    @Getter
    private String resultMessage;
    @Getter
    private Integer resultCode;


    ArchivesCheckEnum(String resultMessage,  Integer resultCode) {
        this.resultMessage = resultMessage;
        this.resultCode = resultCode;

    }




}
