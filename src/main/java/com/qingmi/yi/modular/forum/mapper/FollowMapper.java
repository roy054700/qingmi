package com.qingmi.yi.modular.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingmi.yi.modular.forum.model.Follow;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关注
 * @Author: 李龙真
 * @Date: 2021/3/12 16:12
 */
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {
}
