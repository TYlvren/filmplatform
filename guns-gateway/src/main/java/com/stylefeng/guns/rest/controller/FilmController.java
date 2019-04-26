package com.stylefeng.guns.rest.controller;


import com.stylefeng.guns.rest.persistence.model.vo.commonvo.DataVO;
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

    //@Reference
    FilmService filmService;

    @RequestMapping("getIndex")
    public Map getFilmIndex() {
        Map map = new HashMap();
        FilmIndexVo filmIndexVos = filmService.getFilmIndex();
        if (filmIndexVos != null) {
            map.put("status", 0);
            map.put("imgPre", "http://img.meetingshop.cn/");
            map.put("data", filmIndexVos);
        } else {
            map.put("status", 1);
            map.put("msg", "查询失败，无条件可加载");
        }

        return map;
    }
    @RequestMapping("getConditionList")
    public Object getConditionList(@RequestParam(defaultValue = "99", required = false) String catId,
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
    public Map getSearchFilms( FilmRequestVo filmRequestVo){
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            //分页没做！！！！！！！！！！！！！！！！
            ResponseSearchFIlmVo responseSearchFIlmVo =filmService.searchFilmVoByMultibleCondition(filmRequestVo);
            hashMap.put("status",0);
            hashMap.put("nowPage ",filmRequestVo.getNowPage());
            hashMap.put("totalPage  ", responseSearchFIlmVo.getTotalPage());//总页数需要计算
            hashMap.put("data", responseSearchFIlmVo.getSearchFilmVos());
        } catch (SQLException e) {
            e.printStackTrace();
            hashMap.put("status",1);
            hashMap.put("msg","查询失败,无banner可加载");
        }catch (Exception e) {
            e.printStackTrace();
            hashMap.put("status",999);
            hashMap.put("msg","系统出现异常,请联系管理员");
        }
        //分页没做
        return hashMap;
    }
    @RequestMapping("/films/{value}")
    public Map getFilmDetail(@PathVariable("value") String value, String  searchType ){
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            FilmDetailVo filmDetailVo=filmService.getFilmDetail(searchType,value);
            hashMap.put("status",0);
            hashMap.put("imgPre ","http://img.meetingshop.cn/");
            hashMap.put("data",filmDetailVo);
        } catch (SQLException e) {
            e.printStackTrace();
            hashMap.put("status",1);
            hashMap.put("msg","查询失败，无影片可加载");
        }catch (Exception e) {
            e.printStackTrace();
            hashMap.put("status",999);
            hashMap.put("msg","系统出现异常,请联系管理员");
        }
        return hashMap;

    }

}
