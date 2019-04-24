package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeYearDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.YearDict;

import java.util.List;


public interface MtimeYearDictTMapper extends BaseMapper<MtimeYearDictT> {
    List<YearDict> getYears();
}
