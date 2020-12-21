package com.qingmi.yi.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SysRoleVo {

    //角色id
    private String id;

    //角色名称
    private String roleName;

    //角色英文名称
    private String roleEname;

    //角色类型:
    private Integer roleType;

    //字典编码
    private String roleTypeCode;

    //状态:1：正常 2 删除
    private Integer status;

    //是否内置角色:1 是 2：否
    private Integer isSysset;

    //所属部门
    private String orgId;

    //备注
    private String remark;

    //是否管理员角色:1 是 2：否
    private Integer isManagerRole;

    //创建者
    private String createBy;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //更新者
    private String updateBy;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
