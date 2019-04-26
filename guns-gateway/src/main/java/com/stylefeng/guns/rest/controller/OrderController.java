package com.stylefeng.guns.rest.controller;


import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.ImgPreDataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.MsgVO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.QRCodeVO;
import com.stylefeng.guns.rest.persistence.model.vo.orderVo.ResponseOrderVo;
import com.stylefeng.guns.rest.service.OrderService;
import com.stylefeng.guns.rest.service.UserService;
import com.stylefeng.guns.trade.utils.TradeUtils;
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
                ResponseOrderVo responseOrderVo=orderService.saveOrderInfo(filedId,soldSeats,seatsName,userbo);
                hashMap.put("status",0);
                hashMap.put("msg","");
                hashMap.put("data", responseOrderVo);
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

    @RequestMapping(value = "/getOrderInfo")
    public Map getSearchFilms( @RequestParam(defaultValue = "1", required = false) int nowPage,
                               @RequestParam(defaultValue = "5", required = false) int pageSize,
                               HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            //分页没做！！！！！！！！！！！！！！！！
            UserBO userbo = userService.findUser(request.getAttribute("username").toString());
            List<ResponseOrderVo>  responseOrderVoList= orderService.getOrserVoByUserId(userbo.getUuid(),nowPage,pageSize);
            hashMap.put("status",0);
            hashMap.put("msg","");
            hashMap.put("data",responseOrderVoList);
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
    public StatusVO getPayInfo(String orderId){

        if(orderId == null || orderId.equals("")){
            return new MsgVO(1,"订单支付失败，请稍后重试");
        }

        String qrCodeAddress;
        try {
            qrCodeAddress = TradeUtils.getQRCode(orderId,5);
        }catch (Exception e){
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        return new ImgPreDataVO(0,"",new QRCodeVO(orderId,qrCodeAddress));
    }


}
