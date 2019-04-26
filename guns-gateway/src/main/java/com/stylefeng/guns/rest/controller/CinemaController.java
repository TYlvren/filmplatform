package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.*;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.persistence.model.vo.cinemavo.ConditionVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.DataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.ImgPreDataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.MsgVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.PageVO;
import com.stylefeng.guns.rest.service.CinemaService;
import com.stylefeng.guns.rest.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cinema")
public class CinemaController {

    @Reference
    CinemaService cinemaService;

    @Reference
    OrderService orderService;
    /**
     * 根据条件获取影院
     * @param brandId
     * @param areaId
     * @param hallType
     * @param pageSize
     * @param nowPage
     * @return
     */
    @RequestMapping("getCinemas")
    public StatusVO getCinemas(Integer brandId,Integer areaId,Integer hallType,Integer halltypeId,int pageSize,int nowPage){

        hallType = hallType == null ? halltypeId : hallType;

        if(brandId == null || areaId == null || hallType == null){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }
        List<CinemaBO> cinemas = null;
        try {
            cinemas = cinemaService.findCinemas(new Page(nowPage,pageSize),brandId,areaId,hallType);
        }catch (Exception e){
            e.printStackTrace();
            return new MsgVO(1,"影院信息查询失败");
        }

        /*Map<String,List<CinemaBO>> map = new HashMap<>();
        map.put("cinemas",cinemas);*/
        return new PageVO(0,cinemas,nowPage,pageSize);
    }

    /**
     * 根据条件获取影院 地域 影厅
     * @param brandId
     * @param areaId
     * @param hallType
     * @return
     */
    @RequestMapping("getCondition")
    public StatusVO getCondition(Integer brandId, Integer areaId, Integer hallType){

        List<BrandBO> brandList = null;
        List<AreaBO> areaList = null;
        List<HallTypeBO> halltypeList = null;

        if(brandId == null || areaId == null || hallType == null){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        try {
            brandList = cinemaService.findBrands(brandId);
            areaList = cinemaService.findAreas(areaId);
            halltypeList = cinemaService.findHallTypes(hallType);
        }catch (Exception e){
            e.printStackTrace();
            return new MsgVO(1,"影院信息查询失败");
        }

        if(brandList == null || areaList == null || halltypeList == null){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        //第一个为选中状态
        brandList.get(0).setActive(true);
        areaList.get(0).setActive(true);
        halltypeList.get(0).setActive(true);

        return new DataVO(0,new ConditionVO(brandList,areaList,halltypeList));
    }

    @RequestMapping(value = "getFields",method = {RequestMethod.GET,RequestMethod.POST})
    public StatusVO getFields(Integer cinemaId){

        if(cinemaId == null){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        CinemaInfo cinemaInfo = null;
        List<CinemaFilmBO> cinemaFilms = null;
        try {
            cinemaInfo = cinemaService.findCinema(cinemaId);
            cinemaFilms = cinemaService.findCinemaFilms(cinemaId);
        }catch (Exception e){
            e.printStackTrace();
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("cinemaInfo",cinemaInfo);
        map.put("filmList",cinemaFilms);
        return new DataVO(0,map);
    }

    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    public StatusVO getFieldInfo(Integer cinemaId,Integer fieldId){

        if(cinemaId == null || fieldId == null){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }
        CinemaInfo cinemaInfo = null;
        FilmInfo filmInfo = null;
        HallInfo hallInfo = null;
        try {
            cinemaInfo = cinemaService.findCinema(cinemaId);
            filmInfo = cinemaService.findFilmInfo(fieldId);
            hallInfo = cinemaService.findHallInfo(fieldId);
            hallInfo.setSoldSeats(orderService.getSoldSeatsByFieldId(fieldId));
        }catch (Exception e){
            e.printStackTrace();
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("cinemaInfo",cinemaInfo);
        map.put("filmInfo",filmInfo);
        map.put("hallInfo",hallInfo);
        return new ImgPreDataVO(0,"",map);
    }
}
