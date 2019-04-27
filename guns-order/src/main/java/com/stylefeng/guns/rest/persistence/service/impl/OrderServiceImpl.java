package com.stylefeng.guns.rest.persistence.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeOrderTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.FilmMessageBO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.ResponseOrderVO;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.service.OrderService;
import com.stylefeng.guns.rest.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ygt
 * Date 2019/4/23 0023 Time 11:30
 */
@Service(interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    MtimeOrderTMapper mtimeOrderTMapper;
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;

    @Override
    public Boolean isTrueSeats(String seatAddress, String seatId) throws Exception {
        String JsonContext = new FileUtils().ReadFile(seatAddress);

        //将读取的数据转换为JSONObject
        JSONObject jsonObject1 = JSON.parseObject(JsonContext);

        String ids = (String) jsonObject1.get("ids");
        int limit = (int) jsonObject1.get("limit");
        String[] split = ids.split(",");
        String[] seatIds = seatId.split(",");
        if (seatIds.length > limit) return false;
        for (String id : seatIds) {
            int tag = 0;
            for (String s : split) {
                if (s.equals(id)) {
                    tag = 1;
                    break;
                }
            }
            if (tag == 0) return false;
        }
        return true;
    }

    @Override
    public Boolean isSoldSeats(int filedId, String seatId) throws Exception {
        String s = this.getSoldSeatsByFieldId(filedId);

        String[] seatIds = seatId.split(",");
        String[] soldSeatIds = s.split(",");
        for (String id : seatIds) {
            for (String soldSeatId : soldSeatIds) {
                if (soldSeatId.equals(id)) return true;
            }
        }
        return false;
    }

    @Override
    public ResponseOrderVO saveOrderInfo(FilmMessageBO filmMessageBO, String seatsName) throws Exception {
        ResponseOrderVO responseOrderVO = new ResponseOrderVO();
        responseOrderVO.setCinemaName(filmMessageBO.getCinemaName());
        responseOrderVO.setFilmName(filmMessageBO.getFilmName());
        responseOrderVO.setFieldTime(filmMessageBO.getFieldTime());
        //设置orderId为uuid
        UUID uuid = UUID.randomUUID();
        responseOrderVO.setOrderId(uuid.toString().replace("-", ""));

        //设置时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        responseOrderVO.setOrderTimestamp(df.format(date));
        responseOrderVO.setOrderStatus("未支付");
        responseOrderVO.setSeatsName(seatsName);

        return responseOrderVO;
    }

    /**
     * 添加订单
     * @param filmMessageBO
     * @return
     */
    @Override
    public boolean addOrder(FilmMessageBO filmMessageBO, ResponseOrderVO responseOrderVO, String soldSeats, UserBO userbo) {

        MtimeOrderT mtimeOrderT = new MtimeOrderT();
        mtimeOrderT.setUuid(responseOrderVO.getOrderId());
        mtimeOrderT.setCinemaId(filmMessageBO.getCinemaId());
        mtimeOrderT.setFieldId(filmMessageBO.getFieldId());
        mtimeOrderT.setFilmId(filmMessageBO.getFilmId());
        mtimeOrderT.setSeatsIds(soldSeats);
        mtimeOrderT.setSeatsName(responseOrderVO.getSeatsName());

        //票的价格从哪拿？？是否需要计算总数
        double price = filmMessageBO.getPrice();
        int sum = soldSeats.split(",").length;
        double sumprice = sum * filmMessageBO.getPrice();
        responseOrderVO.setOrderPrice(sumprice);
        mtimeOrderT.setFilmPrice(price);
        mtimeOrderT.setOrderPrice(sumprice);

        //设置时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date parse = null;
        try {
            parse = df.parse(responseOrderVO.getOrderTimestamp());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mtimeOrderT.setOrderTime(parse);

        mtimeOrderT.setOrderUser(userbo.getUuid());
        mtimeOrderT.setOrderStatus(0);

        return mtimeOrderTMapper.insert(mtimeOrderT) == 1;
    }

    @Override
    public List<ResponseOrderVO> getOrserVoByUserId(int userId, int nowPage, int pageSize) throws Exception {
        //需要分页！！！！！！！
        List<ResponseOrderVO> responseOrderVOS = mtimeOrderTMapper.searchResponseOrdersByUserId(userId);
        for (ResponseOrderVO responseOrderVO : responseOrderVOS) {
            String orderStatus = responseOrderVO.getOrderStatus();
            switch (orderStatus) {
                case "0": {
                    responseOrderVO.setOrderStatus("待支付");
                    break;
                }
                case "1": {
                    responseOrderVO.setOrderStatus("已支付");
                    break;
                }
                case "2": {
                    responseOrderVO.setOrderStatus("已关闭");
                    break;
                }
            }
        }
        return responseOrderVOS;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer filedId) {
        List<String> saledSeats = mtimeOrderTMapper.selectSeatsIdsByfiledId(filedId);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < saledSeats.size(); i++) {
            if (i == 0) stringBuffer.append(saledSeats.get(i) + ",");
            else if (i == (saledSeats.size() - 1)) stringBuffer.append(saledSeats.get(i));
            else {
                stringBuffer.append(saledSeats.get(i) + ",");
            }
        }

        return stringBuffer.toString();
    }

    @Override
    public double searchSumPriceByOrderId(String orderId) {
        return mtimeOrderTMapper.searchPriceByOrderId(orderId);
    }


    @Override
    public void updateOrderStatus(String orderId) {
        mtimeOrderTMapper.updateOrderStatus(orderId);
    }
}
