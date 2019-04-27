package com.stylefeng.guns.rest.service;


import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.FilmMessageBO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.ResponseOrderVO;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;

import java.util.List;

public interface OrderService {
    Boolean isTrueSeats (String seatAddress,String seatId) throws Exception;
    Boolean isSoldSeats (int filedId,String seatId) throws Exception;

    ResponseOrderVO saveOrderInfo(FilmMessageBO filmMessageBO, String seatsName) throws Exception;


    boolean addOrder(FilmMessageBO filmMessageBO, ResponseOrderVO responseOrderVO, String soldSeats, UserBO userbo);

    List<ResponseOrderVO> getOrserVoByUserId(int userId, int nowPage, int pageSize) throws Exception;
    String getSoldSeatsByFieldId(Integer filedId);

    double searchSumPriceByOrderId(String orderId);

    void updateOrderStatus(String orderId);
}
