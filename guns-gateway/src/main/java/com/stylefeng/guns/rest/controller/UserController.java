package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    UserService userService;

    /**
     * 用户注册
     * @param requestUser
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public StatusVO register(RequestUser requestUser){

        boolean check = userService.checkUser(requestUser.getUsername());
        if(!check){
            return new StatusVO(1,"用户已存在");
        }

        boolean register = userService.register(requestUser);
        if(register){
            return new StatusVO(0,"注册成功");
        }else {
            return new StatusVO(999, "系统出现异常，请联系管理员");
        }
    }


    /**
     * 检查用户名
     * @param username
     * @return
     */
    @RequestMapping(value = "check",method = RequestMethod.POST)
    public StatusVO check(String username){
        boolean check = userService.checkUser(username);
        if(check){
            return new StatusVO(0,"验证成功");
        }else {
            return new StatusVO(1,"用户已存在");
        }
    }

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private Jedis jedis;

    @RequestMapping("logout")
    public StatusVO logout(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");
        Long del = jedis.del(username);
        if(del == 1){
            return new StatusVO(0,"成功退出");
        }else if(del == 0){
            return new StatusVO(1,"退出失败，用户尚未登陆");
        }else {
            return new StatusVO(999,"系统出现异常，请联系管理员");
        }
    }
}
