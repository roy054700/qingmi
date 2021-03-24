package com.qingmi.yi.modular.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingmi.yi.modular.forum.model.WorkCollection;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作品收藏
 * @Author: 李龙真
 * @Date: 2021/3/10 16:18
 */
@Mapper
public interface CollectionMapper extends BaseMapper<WorkCollection> {
}
