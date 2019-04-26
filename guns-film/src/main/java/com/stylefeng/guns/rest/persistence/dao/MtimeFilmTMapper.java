package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SearchFilmBO;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;


public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {
    LinkedList<SearchFilmBO> searchFilmsOrderByMultibleCondition(@Param("showType") Integer showType, @Param("sortId") Integer sortId, @Param("catId") Integer catId, @Param("sourceId") Integer sourceId, @Param("yearId") Integer yearId);

    MtimeFilmT searchByFilmName(@Param("filmName") String value);

    MtimeFilmT searchByUUID(@Param("uuid") Integer uuid);
}
