package com.stylefeng.guns.rest.controller;


import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.PageVO;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmConditionVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmDetailVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.FilmRequestVo;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.ResponseSearchFIlmVo;

import com.stylefeng.guns.rest.persistence.model.vo.commonvo.DataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.ImgPreDataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.MsgVO;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.*;

import com.stylefeng.guns.rest.service.FilmService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 15:57
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Reference
    FilmService filmService;

    @RequestMapping("getIndex")
    public StatusVO getFilmIndex() {
        Map map = new HashMap();
        FilmIndexVo filmIndexVos = filmService.getFilmIndex();
        if (filmIndexVos != null) {
            return new ImgPreDataVO(0,"http://img.meetingshop.cn/",filmIndexVos);
        } else {
            return new MsgVO(1,"查询失败，无条件可加载");
        }
    }

    @RequestMapping("getConditionList")
    public StatusVO getConditionList(@RequestParam(defaultValue = "99", required = false) String catId,
                                @RequestParam(defaultValue = "99", required = false) String sourceId,
                                @RequestParam(defaultValue = "99", required = false) String yearId) {

        FilmConditionVo filmConditionVo = filmService.selectFilmCondition(catId, sourceId, yearId);
        if (filmConditionVo != null) {
            return new DataVO(0,filmConditionVo);
        } else {
            return new MsgVO(1,"查询失败，无条件可加载");
        }
    }

    @RequestMapping(value = "/getFilms")
    public StatusVO getSearchFilms( FilmRequestVo filmRequestVo){
        try {
            //分页没做！！！！！！！！！！！！！！！！,使用Mybatis-plus做
            ResponseSearchFIlmVo responseSearchFIlmVo =filmService.searchFilmVoByMultibleCondition(filmRequestVo);

           return new PageVO(0,responseSearchFIlmVo.getSearchFilmBOS(),filmRequestVo.getNowPage(),responseSearchFIlmVo.getTotalPage());
        } catch (SQLException e) {
            e.printStackTrace();
            return new MsgVO(1,"查询失败,无banner可加载");
        }catch (Exception e) {
            e.printStackTrace();
            return new MsgVO(999,"系统出现异常,请联系管理员");
        }
    }
    @RequestMapping("/films/{value}")
    public StatusVO getFilmDetail(@PathVariable("value") String value, String  searchType ){
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            FilmDetailVo filmDetailVo=filmService.getFilmDetail(searchType,value);
            return new ImgPreDataVO(0,"http://img.meetingshop.cn/",filmDetailVo);
        } catch (SQLException e) {
            e.printStackTrace();
            return new MsgVO(1,"查询失败，无影片可加载");
        }catch (Exception e) {
            e.printStackTrace();
            return new MsgVO(999,"系统出现异常,请联系管理员");
        }
    }
}
