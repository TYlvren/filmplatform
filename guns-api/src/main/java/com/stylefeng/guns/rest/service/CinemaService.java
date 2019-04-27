package com.stylefeng.guns.rest.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.*;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.FilmMessageBO;

import java.util.List;

public interface CinemaService {

    /**
     * 查询电影院
     * @param page
     * @param brandId
     * @param areaId
     * @param hallType
     * @return
     */
    List<CinemaBO> findCinemas(Page page, int brandId, int areaId, int hallType);

    /**
     * 查询影院品牌
     * @param brandId
     * @return
     */
    List<BrandBO> findBrands(int brandId);

    /**
     * 查询影院地域
     * @param areaId
     * @return
     */
    List<AreaBO> findAreas(int areaId);

    /**
     * 查询影院影厅类型
     * @param hallType
     * @return
     */
    List<HallTypeBO> findHallTypes(int hallType);

    /**
     * 通过cinemaId查找cinema
     * @param cinemaId
     * @return
     */
    CinemaInfo findCinema(Integer cinemaId);



    /**
     * 查找电影院电影及其场次
     * @param cinemaId
     * @return
     */
    List<CinemaFilmBO> findCinemaFilms(Integer cinemaId);

    /**
     * 查找对应场次的电影信息
     * @param fieldId
     * @return
     */
    FilmInfo findFilmInfo(Integer fieldId);


    /**
     * 获取场次信息
     * @param fieldId
     * @return
     */
    HallInfo findHallInfo(Integer fieldId);

    FilmMessageBO findFilmMessageBO(int fieldId);
}
