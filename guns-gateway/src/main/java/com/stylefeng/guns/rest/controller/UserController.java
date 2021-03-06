package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.DataVO;
import com.stylefeng.guns.rest.persistence.model.vo.commonvo.MsgVO;
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
    public MsgVO register(RequestUser requestUser){

        boolean check = userService.checkUser(requestUser.getUsername());
        if(!check){
            return new MsgVO(1,"用户已存在");
        }

        boolean register = userService.register(requestUser);
        if(register){
            return new MsgVO(0,"注册成功");
        }else {
            return new MsgVO(999, "系统出现异常，请联系管理员");
        }
    }


    /**
     * 检查用户名
     * @param username
     * @return
     */
    @RequestMapping(value = "check",method = RequestMethod.POST)
    public MsgVO check(String username){
        boolean check = userService.checkUser(username);
        if(check){
            return new MsgVO(0,"验证成功");
        }else {
            return new MsgVO(1,"用户已存在");
        }
    }

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private Jedis jedis;

    /**
     * 用户登出
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public MsgVO logout(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        if(username == null || "".equals(username)){
            return new MsgVO(1,"退出失败，用户尚未登陆");
        }
        Long del = jedis.del(username);
        if(del == 1){
            return new MsgVO(0,"成功退出");
        }else if(del == 0){
            return new MsgVO(1,"退出失败，用户尚未登陆");
        }else {
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }
    }

    /**
     * 查询已登录用户的信息
     * @param request
     * @return
     */
    @RequestMapping("getUserInfo")
    public StatusVO getUserInfo(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        UserBO userBO = userService.findUser(username);
        if(userBO == null){
            return new DataVO(999,"系统出现异常，请联系管理员");
        }
        return new DataVO(0, userBO);
    }

    /**
     * 修改用户信息
     * @param userBO
     * @return
     */
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public StatusVO updateUserInfo(UserBO userBO){

        boolean update = false;
        try {
            update = userService.updateUser(userBO);
            userBO = userService.findUser(userBO.getUuid());
        }catch (Exception e){
            e.printStackTrace();
            return new MsgVO(999,"系统出现异常，请联系管理员");
        }

        if(update){
            return new DataVO(0,userBO);
        }else {
            return new MsgVO(1,"用户信息修改失败");
        }
    }
}
