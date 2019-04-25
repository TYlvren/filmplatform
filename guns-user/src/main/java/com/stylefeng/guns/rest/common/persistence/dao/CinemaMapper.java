package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.cskaoyan.filmplatform.cinema.common.persistence.model.Cinema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lvhong
 * @since 2019-04-20
 */
public interface CinemaMapper  { //extends BaseMapper<Cinema> 继承BaseMapper伪物理分页



    /**
     * <p>
     * 查询 : 根据条件查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    List<Cinema> selectCinemaByBrandIdAndAreaIdAndHallType(Page page,
                                                           @Param("brandId") int brandId,
                                                           @Param("areaId") int areaId,
                                                           @Param("hallType") int hallType);



}
