package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
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

    String selectSeatAddress(@Param("filedId")int filedId);
}
