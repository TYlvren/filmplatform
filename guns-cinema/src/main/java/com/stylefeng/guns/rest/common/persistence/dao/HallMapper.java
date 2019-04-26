package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.HallInfo;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.HallTypeBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallMapper {
    List<HallTypeBO> selectHallByUUID(@Param("hallType") int hallType);

    HallInfo selectHallByFieldId(@Param("fieldId") Integer fieldId);
}
