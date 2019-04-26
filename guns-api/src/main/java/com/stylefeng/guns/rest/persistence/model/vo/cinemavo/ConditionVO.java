package com.stylefeng.guns.rest.persistence.model.vo.cinemavo;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.AreaBO;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.BrandBO;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.HallTypeBO;

import java.io.Serializable;
import java.util.List;

public class ConditionVO implements Serializable {
    private static final long serialVersionUID = -7461435136857462863L;

    List<BrandBO> brandList;
    List<AreaBO> areaList;
    List<HallTypeBO> halltypeList;


    public ConditionVO() {
    }

    public ConditionVO(List<BrandBO> brandList, List<AreaBO> areaList, List<HallTypeBO> halltypeList) {
        this.brandList = brandList;
        this.areaList = areaList;
        this.halltypeList = halltypeList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<BrandBO> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandBO> brandList) {
        this.brandList = brandList;
    }

    public List<AreaBO> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaBO> areaList) {
        this.areaList = areaList;
    }

    public List<HallTypeBO> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<HallTypeBO> halltypeList) {
        this.halltypeList = halltypeList;
    }
}
