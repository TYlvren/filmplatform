package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.*;
import com.stylefeng.guns.rest.persistence.model.vo.StatusDataVO;
import com.stylefeng.guns.rest.persistence.model.vo.StatusMsgVO;
import com.stylefeng.guns.rest.persistence.model.vo.cinemavo.BrandsVO;
import com.stylefeng.guns.rest.persistence.model.vo.cinemavo.CinemasVO;
import com.stylefeng.guns.rest.service.CinemaService;
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
    public Object getCinemas(Integer brandId,Integer areaId,Integer hallType,Integer halltypeId,int pageSize,int nowPage){
        List<CinemaBO> cinemas = null;
        hallType = hallType == null ? halltypeId : hallType;


        if(brandId == null || areaId == null || hallType == null){
            return new StatusMsgVO(999,"系统出现异常，请联系管理员");
        }

        try {
            cinemas = cinemaService.findCinemas(new Page(nowPage,pageSize),brandId,areaId,hallType);
        }catch (Exception e){
            e.printStackTrace();
            return new StatusMsgVO(1,"影院信息查询失败");
        }


        /*Map<String,List<CinemaBO>> map = new HashMap<>();
        map.put("cinemas",cinemas);*/
        return new CinemasVO(0,nowPage,pageSize,cinemas);
    }

    /**
     * 根据条件获取影院 地域 影厅
     * @param brandId
     * @param areaId
     * @param hallType
     * @return
     */
    @RequestMapping("getCondition")
    public Object getCondition(Integer brandId,Integer areaId,Integer hallType){

        List<BrandBO> brandList = null;
        List<AreaBO> areaList = null;
        List<HallTypeBO> halltypeList = null;

        if(brandId == null || areaId == null || hallType == null){
            return new StatusMsgVO(999,"系统出现异常，请联系管理员");
        }

        try {
            brandList = cinemaService.findBrands(brandId);
            areaList = cinemaService.findAreas(areaId);
            halltypeList = cinemaService.findHallTypes(hallType);
        }catch (Exception e){
            e.printStackTrace();
            return new StatusMsgVO(1,"影院信息查询失败");
        }

        if(brandList == null || areaList == null || halltypeList == null){
            return new StatusMsgVO(999,"系统出现异常，请联系管理员");
        }

        //第一个为选中状态
        brandList.get(0).setActive(true);
        areaList.get(0).setActive(true);
        halltypeList.get(0).setActive(true);

        Map<String,List> map = new HashMap<>();
        map.put("brandList",brandList);
        map.put("areaList",areaList);
        map.put("halltypeList",halltypeList);


        return new BrandsVO(0,map);
    }

    @RequestMapping(value = "getFields",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getFields(Integer cinemaId){

        if(cinemaId == null){
            return new StatusMsgVO(999,"系统出现异常，请联系管理员");
        }

        CinemaInfo cinemaInfo = cinemaService.findCinema(cinemaId);

        return new StatusDataVO(0,cinemaInfo);
    }

}
