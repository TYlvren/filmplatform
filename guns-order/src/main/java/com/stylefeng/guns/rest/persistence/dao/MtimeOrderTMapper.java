package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.ResponseOrderBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author ygt
 * @since 2019-04-25
 */
public interface MtimeOrderTMapper extends BaseMapper<MtimeOrderT> {

    List<String> selectSeatsIdsByfiledId(@Param("filedId")int filedId);

    List<MtimeOrderT> searchOrdersByUserId(@Param("userId")int userId);

    List<ResponseOrderBo> searchResponseOrdersByUserId(@Param("userId")int userId);

    double searchPriceByOrderId(@Param("orderId")String orderId);
}
