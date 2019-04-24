package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeSourceDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SourceDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MtimeSourceDictTMapper extends BaseMapper<MtimeSourceDictT> {
    List<SourceDict> getSources();

    String searchAreaById(@Param("uuid") Integer filmArea);
}
