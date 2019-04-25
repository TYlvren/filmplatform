package com.stylefeng.guns.rest.persistence.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeOrderTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.SeatJsonBo;

import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.ResponseOrderVo;
import com.stylefeng.guns.rest.service.OrderService;
import com.stylefeng.guns.rest.utils.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Boolean isTrueSeats(int filedId, String seatId) throws Exception{
        //影院获取文件路径接口没实现!!!!!!!!!
        String JsonContext = new FileUtils().ReadFile("D:\\王道\\课件\\Project4\\接口文档\\订单模块接口文档\\cgs.json");
        //将读取的数据转换为JSONObject
        JSONObject jsonObject1 = JSON.parseObject(JsonContext);
        String ids =(String) jsonObject1.get("ids");
        int limit =(int) jsonObject1.get("limit");
        String[] split = ids.split(",");
        String[] seatIds = seatId.split(",");
        if(seatIds.length>limit)return false;
        for (String id : seatIds) {
            int tag=0;
            for (String s : split) {
                if(s.equals(id)) {
                    tag=1;
                    break;
                }
            }
            if(tag==0)return false;
        }
        return true;
    }
    @Override
    public Boolean isSoldSeats(int filedId, String seatId) throws Exception{
         List<String> saledSeats= mtimeOrderTMapper.selectSeatsIdsByfiledId(filedId);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<saledSeats.size();i++) {
            if(i==0||i==saledSeats.size()-1)stringBuffer.append(saledSeats.get(i));
            else {
                stringBuffer.append(","+saledSeats.get(i));
            }
        }
        String s = stringBuffer.toString();
        String[] seatIds = seatId.split(",");
        String[] soldSeatIds = s.split(",");
        for (String id : seatIds) {
            for (String soldSeatId : soldSeatIds) {
                if(soldSeatId.equals(id))return true;
            }
        }
        return false;
    }

    @Override
    public ResponseOrderVo saveOrderInfo(int filedId, String soldSeats, String seatsName, UserBO userbo) throws Exception{
        ResponseOrderVo responseOrderVo = new ResponseOrderVo();

        //String cinamaName= cinamaservice.getNameByfiledId(filedId)
        MtimeFieldT mtimeField=  mtimeFieldTMapper.searchByFiledId(filedId);
        Integer cinemaId = mtimeField.getCinemaId();
        //获取电影院名称
        responseOrderVo.setCinemaName("电影院名称查询接口");


        //可能需要拼接字符串
        responseOrderVo.setFieldTime(mtimeField.getBeginTime());
        Integer filmId = mtimeField.getFilmId();
        //查询电影名称
        responseOrderVo.setFilmName("电影名称查询接口");
        //设置orderId为uuid
        UUID uuid = UUID.randomUUID();
        responseOrderVo.setOrderId( uuid.toString());

        //票的价格从哪拿？？是否需要计算总数
         double perprice=  (double)mtimeField.getPrice();
        int sum = soldSeats.split(",").length;
        double sumprice=sum*perprice;
        responseOrderVo.setOrderPrice(sumprice);

        //设置时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        responseOrderVo.setOrderTimestamp( df.format(date));


        responseOrderVo.setSeatsName(seatsName);
        MtimeOrderT mtimeOrderT = new MtimeOrderT();
        mtimeOrderT.setUuid(uuid.toString());
        mtimeOrderT.setCinemaId(mtimeField.getCinemaId());
        mtimeOrderT.setFieldId(filedId);
        mtimeOrderT.setFilmId(mtimeField.getFilmId());
        mtimeOrderT.setSeatsIds(soldSeats);
        mtimeOrderT.setSeatsName(seatsName);
        mtimeOrderT.setFilmPrice(perprice);
        mtimeOrderT.setOrderPrice(sumprice);
        mtimeOrderT.setOrderTime(date);
        mtimeOrderT.setOrderUser(userbo.getUuid());
        mtimeOrderT.setOrderStatus(0);
        Integer insert = mtimeOrderTMapper.insert(mtimeOrderT);
        return responseOrderVo;
    }

    @Override
    public List<ResponseOrderVo> getOrserVoByUserId(int userId, int nowPage, int pageSize) throws Exception{
        //需要分页！！！！！！！
         List<MtimeOrderT> mtimeOrderTList=mtimeOrderTMapper.searchOrdersByUserId(userId);



        return null;
    }
}
