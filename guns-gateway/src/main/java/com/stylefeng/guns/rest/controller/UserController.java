package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
