package com.qingmi.yi.modular.wuyunliuqi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 五运六气
 * @Author: 李龙真
 * @Date: 2020/12/27 13:22
 */
@Data
@TableName("wuyun_liuqi")
public class WuYunLiuQi extends Model<WuYunLiuQi> {
    public int id;
    public String oneName;
    public String towName;
    public String threeName;
    public int tianId;
    public int type;
    public int sort;
}
