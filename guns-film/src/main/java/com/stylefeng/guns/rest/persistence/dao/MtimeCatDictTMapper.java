package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.MtimeCatDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatDict;

import java.util.List;


public interface MtimeCatDictTMapper extends BaseMapper<MtimeCatDictT> {
    List<CatDict> getCats();

    String searchById(String id);
}
