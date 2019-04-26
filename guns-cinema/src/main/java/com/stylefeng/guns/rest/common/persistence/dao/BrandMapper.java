package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.BrandBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<BrandBO> selectBrandByUUID(@Param("brandId") int brandId);
}

