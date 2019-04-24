package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;
import com.stylefeng.guns.rest.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public StatusVO register(UserBO userBO) {

        UserBO userByUsername = userMapper.selectUserByUsername(userBO.getUsername());

        if(userByUsername == null){
            return new StatusVO(1,"用户已存在");
        }

        String password = MD5Utils.getMD5(userBO.getPassword());
        userBO.setPassword(password);

        int i = userMapper.insertUser(userBO);
        if(i != 1 ){
            return new StatusVO(999,"系统出现异常，请联系管理员");
        }

        return new StatusVO(0,"注册成功");
    }

    /**
     * 通过用户名检查用户是否存在
     *
     * @param username
     * @return
     */
    @Override
    public StatusVO checkUser(String username) {

        UserBO userByUsername = userMapper.selectUserByUsername(username);

        if(userByUsername == null){
            return new StatusVO(1,"用户已存在");
        }else {
            return new StatusVO(0,"验证成功");
        }
    }
}
