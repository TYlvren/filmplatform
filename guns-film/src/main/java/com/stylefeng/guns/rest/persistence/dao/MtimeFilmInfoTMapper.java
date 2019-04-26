package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.MtimeFilmInfoT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MtimeFilmInfoTMapper extends BaseMapper<MtimeFilmInfoT> {

    MtimeFilmInfoT selectbyFilmId(@Param("filmId") String value);

    MtimeFilmInfoT searchByUUID(@Param("uuid") Integer uuid);

    //获取票房排行榜
    List<FilmInfo> getBoxRanking();
    //获取人气排行榜
    List<FilmInfo> getExpectRanking();
    //获取top100
    List<FilmInfo> getTop();
}
