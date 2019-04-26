package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = CinemaService.class)
@Component
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaMapper cinemaMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    AreaMapper areaMapper;

    @Autowired
    HallMapper hallMapper;

    @Autowired
    FieldMapper fieldMapper;

    /**
     * 查询电影院
     *
     * @param page
     * @param brandId
     * @param areaId
     * @param hallType
     * @return
     */
    @Override
    public List<CinemaBO> findCinemas(Page page, int brandId, int areaId, int hallType) {
        return cinemaMapper.selectCinemaByBrandIdAndAreaIdAndHallType(page,brandId,areaId,hallType);

    }

    /**
     * 查询影院品牌
     *
     * @param brandId
     * @return
     */
    @Override
    public List<BrandBO> findBrands(int brandId) {
        return brandMapper.selectBrandByUUID(brandId);
    }

    /**
     * 查询影院地域
     *
     * @param areaId
     * @return
     */
    @Override
    public List<AreaBO> findAreas(int areaId) {
        return areaMapper.selectAreaByUUID(areaId);
    }

    /**
     * 查询影院影厅类型
     *
     * @param hallType
     * @return
     */
    @Override
    public List<HallTypeBO> findHallTypes(int hallType) {
        return hallMapper.selectHallByUUID(hallType);
    }

    /**
     * 通过cinemaId查找cinema
     *
     * @param cinemaId
     * @return
     */
    @Override
    public CinemaInfo findCinema(Integer cinemaId) {
        return cinemaMapper.selectCinemaByUUID(cinemaId);
    }

    /**
     * 查找电影院电影及其场次
     *
     * @param cinemaId
     * @return
     */
    @Override
    public List<CinemaFilmBO> findCinemaFilms(Integer cinemaId) {
        return fieldMapper.selectHallFilmInfosAndFieldsByCinemaId(cinemaId);
    }


    /**
     * 查找对应场次的电影信息
     *
     * @param fieldId
     * @return
     */
    @Override
    public FilmInfo findFilmInfo(Integer fieldId) {
        return fieldMapper.selectFilmInfo(fieldId);
    }

    /**
     * 获取场次信息
     *
     * @param fieldId
     * @return
     */
    @Override
    public HallInfo findHallInfo(Integer fieldId) {
        return hallMapper.selectHallByFieldId(fieldId);
    }
}
