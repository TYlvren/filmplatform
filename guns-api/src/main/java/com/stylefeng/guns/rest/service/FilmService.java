package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmConditionVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmDetailVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmRequestVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.ResponseSearchFIlmVo;

/**
 * Created by Flying Elephant
 * Date 2019/4/21 0021 Time 19:29
 */
public interface FilmService {

    FilmConditionVo selectFilmCondition(String catId, String sourceId, String yearId);
    ResponseSearchFIlmVo searchFilmVoByMultibleCondition(FilmRequestVo filmRequestVo) throws Exception;

    FilmDetailVo getFilmDetail(String searchType, String value) throws Exception;
    
}
