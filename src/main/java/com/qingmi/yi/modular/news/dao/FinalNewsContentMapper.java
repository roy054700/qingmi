package com.qingmi.yi.modular.news.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingmi.yi.modular.news.model.FinalNewsContent;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FinalNewsContentMapper extends BaseMapper<FinalNewsContent> {


    /**
     * 分页查询信息
     *
     */
     //List<FinalNewsContent> selectPage(@Param("page") Pagination pagination, @Param("p") FinalNewsContent model, @Param("w") Wrapper<FinalNewsContent> wrapper);

    List<FinalNewsContent> selectPage(@Param("p") Page<FinalNewsContent> page, @Param("e") FinalNewsContent model);
}
