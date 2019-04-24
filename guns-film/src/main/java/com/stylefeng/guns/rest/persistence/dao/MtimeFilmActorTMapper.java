package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeFilmActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-24
 */
public interface MtimeFilmActorTMapper extends BaseMapper<MtimeFilmActorT> {

    LinkedList<Actor> searchByFilmId(@Param("filmId") String filmId);
}
