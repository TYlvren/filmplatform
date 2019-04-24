package com.stylefeng.guns.rest.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
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

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public StatusVO register(UserBO userBO){
        return userService.register(userBO);
    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    public StatusVO check(String username){
        return userService.checkUser(username);
    }
}
