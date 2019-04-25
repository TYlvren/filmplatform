package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.common.persistence.dao.AreaMapper;
import com.stylefeng.guns.rest.common.persistence.dao.BrandMapper;
import com.stylefeng.guns.rest.common.persistence.dao.CinemaMapper;
import com.stylefeng.guns.rest.common.persistence.dao.HallTypeMapper;
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
    HallTypeMapper hallTypeMapper;

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
        return hallTypeMapper.selectHallTypeByUUID(hallType);
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
}
