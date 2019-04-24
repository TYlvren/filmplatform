package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeCatDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatDict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MtimeCatDictTMapper extends BaseMapper<MtimeCatDictT> {
    List<CatDict> getCats();

    String searchById(String id);
}
