package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.controller.dto.TakenVO;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Reference
    UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "${jwt.auth-path}")
    public Object createAuthenticationToken(String username,String password) {
        try {
            boolean validate = userService.findUser(username,password);

            if (validate) {
                final String randomKey = jwtTokenUtil.getRandomKey();
                final String token = jwtTokenUtil.generateToken(username, randomKey);

                return new TakenVO(0,new AuthResponse(token, randomKey));
            } else {
                return new StatusVO(1, "用户名或密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new StatusVO(999, "系统出现异常，请联系管理员");
        }
    }
}
