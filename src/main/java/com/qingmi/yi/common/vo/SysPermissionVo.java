package com.qingmi.yi.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SysPermissionVo {
    //主键id
    private String id;

    //权限类型：1：菜单 2：文件  3：数据权限
    private Integer permissionType;

    //权限名称
    private String permissionName;

    //权限id
    private String permissionId;

    //菜单权限
    private SysMenuVo sysMenuVo;

    //菜单权限集合
    private List<SysMenuVo> sysMenuVoList = new ArrayList<>();

    //文件权限

    //数据权限

}
