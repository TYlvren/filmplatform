package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.CinemaFilmBO;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.FilmInfo;

import java.util.List;

public interface FieldMapper {


    List<CinemaFilmBO> selectHallFilmInfosAndFieldsByCinemaId(Integer cinemaId);

    FilmInfo selectFilmInfo(Integer fieldId);
}
