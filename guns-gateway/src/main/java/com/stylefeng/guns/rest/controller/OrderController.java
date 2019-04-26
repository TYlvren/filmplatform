package com.stylefeng.guns.rest.controller;


import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.ResponseOrderBo;
import com.stylefeng.guns.rest.service.OrderService;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ygt
 * Date 2019/4/24 Time 15:57
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    //@Reference
    OrderService orderService;
    //@Reference
    UserService userService;

    @RequestMapping(value = "/buyTickets" ,method = RequestMethod.POST)
    //filedId如果不传会出现格式化问题
    public Map buyTicketsController(int filedId,
                                    String soldSeats,
                                    String seatsName, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //System.out.println(request.getAttribute("username"));
        try {

            if(soldSeats==null || seatsName==null)throw new SQLException("参数异常");
            Boolean trueSeats1= orderService.isTrueSeats(filedId, soldSeats);//true表示可以下单
            Boolean soldSeats1 = orderService.isSoldSeats(filedId, soldSeats);//false表示可以下单
            if(trueSeats1&&!soldSeats1){
                UserBO userbo = userService.findUser(request.getAttribute("username").toString());
                ResponseOrderBo responseOrderBo =orderService.saveOrderInfo(filedId,soldSeats,seatsName,userbo);
                hashMap.put("status",0);
                hashMap.put("msg","");
                hashMap.put("data", responseOrderBo);
            }else{
                hashMap.put("status",1);
                hashMap.put("msg","该订单不存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            hashMap.put("status",1);
            hashMap.put("msg","该订单不存在");
        }catch (Exception e) {
            e.printStackTrace();
            hashMap.put("status",999);
            hashMap.put("msg","系统出现异常,请联系管理员");
        }
        return hashMap;
    }

    @RequestMapping(value = "/getOrderInfo",method = RequestMethod.POST)
    public Map getSearchFilms( @RequestParam(defaultValue = "1", required = false) int nowPage,
                               @RequestParam(defaultValue = "5", required = false) int pageSize,
                               HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            //分页没做！！！！！！！！！！！！！！！！
            UserBO userbo = userService.findUser(request.getAttribute("username").toString());
            List<ResponseOrderBo> responseOrderBoList = orderService.getOrserVoByUserId(userbo.getUuid(),nowPage,pageSize);
            hashMap.put("status",0);
            hashMap.put("msg","");
            hashMap.put("data", responseOrderBoList);
        } catch (SQLException e) {
            e.printStackTrace();
            hashMap.put("status",1);
            hashMap.put("msg","订单列表为空哦！~");
        }catch (Exception e) {
            e.printStackTrace();
            hashMap.put("status",999);
            hashMap.put("msg","系统出现异常,请联系管理员");
        }
        //分页没做
        return hashMap;
    }


    @RequestMapping(value = "getPayInfo",method = RequestMethod.POST)
    public Object getPayInfo(String orderId){
                double price = orderService.searchSumPriceByOrderId(orderId);
      return null;
    }


}
