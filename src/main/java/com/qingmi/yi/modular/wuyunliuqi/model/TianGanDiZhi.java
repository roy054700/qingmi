package com.qingmi.yi.modular.wuyunliuqi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Author: 李龙真
 * @Date: 2020/12/28 17:20
 */
@Data
@TableName("tiangan_dizhi")
public class TianGanDiZhi extends Model<TianGanDiZhi> {

    private int id;
    private String name;
}
