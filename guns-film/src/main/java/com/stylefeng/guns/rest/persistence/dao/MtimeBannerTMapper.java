package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeBannerT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmInfo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.BannerVo;

import java.util.List;


public interface MtimeBannerTMapper extends BaseMapper<MtimeBannerT> {
    List<BannerVo> getBanners();

    List<FilmInfo> getHotFilms();

    List<FilmInfo> getSoonFilms();
}
