package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.HallTypeBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallTypeMapper {
    List<HallTypeBO> selectHallTypeByUUID(@Param("hallType") int hallType);
}
