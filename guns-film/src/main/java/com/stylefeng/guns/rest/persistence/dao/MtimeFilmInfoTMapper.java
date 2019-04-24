package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeFilmInfoT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


public interface MtimeFilmInfoTMapper extends BaseMapper<MtimeFilmInfoT> {

    MtimeFilmInfoT selectbyFilmId(@Param("filmId") String value);

    MtimeFilmInfoT searchByUUID(@Param("uuid") Integer uuid);
}
