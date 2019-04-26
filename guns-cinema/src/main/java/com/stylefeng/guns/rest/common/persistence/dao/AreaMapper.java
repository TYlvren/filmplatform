package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.AreaBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    List<AreaBO> selectAreaByUUID(@Param("areaId") int areaId);
}
