package com.qingmi.yi.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SysMenuVo {
    //菜单id
    private String id;

    //父ID
    private String parentId;

    //父id 组
    private String parentIds;

    @JsonProperty("name")
    //菜单名称
    private String menuName;

    //菜单英文名称
    private String menuEname;

    //前端路由地址
    private String path;

    //请求地址
    private String url;

    //排序
    private Integer sort;

    //状态:1：正常 2 删除
    private Integer status;

    //字典编码
    private String menuTypeCode;

    //菜单类型
    private Integer menuType;

    //图标
    private String icon;

    //是否显示 1：是 2:否
    private Integer isShow;

    //权限码
    private String permission;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    //树级
    private Integer level;

    //叶子节点
    private Integer isLeaf;

    //备注
    private String remark;

    @TableField(exist = false)
    private List<SysMenuVo> children = new ArrayList<SysMenuVo>();
}
