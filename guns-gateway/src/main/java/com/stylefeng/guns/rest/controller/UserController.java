package com.stylefeng.guns.rest.controller;

import com.stylefeng.guns.rest.utilBeans.StatusBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("register")
    public StatusBean register(){
        return null;
    }

}
