package com.stylefeng.guns.rest.service;


import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.ResponseOrderBo;

import java.util.List;

public interface OrderService {
    Boolean isTrueSeats (int filedId,String seatId) throws Exception;
    Boolean isSoldSeats (int filedId,String seatId) throws Exception;

    ResponseOrderBo saveOrderInfo(int filedId, String soldSeats, String seatsName, UserBO userbo) throws Exception;

    List<ResponseOrderBo> getOrserVoByUserId(int userId, int nowPage, int pageSize) throws Exception;
    String getSoldSeatsByFieldId(Integer filedId);

    double searchSumPriceByOrderId(String orderId);

    void updateOrderStatus(String orderId);
}
