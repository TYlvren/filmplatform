package com.stylefeng.guns.rest.service;


import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.ResponseOrderVo;

import java.util.List;

public interface OrderService {
    Boolean isTrueSeats (int filedId,String seatId) throws Exception;
    Boolean isSoldSeats (int filedId,String seatId) throws Exception;

    ResponseOrderVo saveOrderInfo(int filedId, String soldSeats, String seatsName, UserBO userbo) throws Exception;

    List<ResponseOrderVo> getOrserVoByUserId(int userId, int nowPage, int pageSize) throws Exception;
}
