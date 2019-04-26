package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author ygt
 * @since 2019-04-25
 */
public interface MtimeFieldTMapper extends BaseMapper<MtimeFieldT> {

    MtimeFieldT searchByFiledId(@Param("filedId")int filedId);
}
