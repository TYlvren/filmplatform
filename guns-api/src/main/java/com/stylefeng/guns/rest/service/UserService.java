package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;


public interface UserService {

    StatusVO register(UserBO userBO);

    /**
     * 通过用户名检查用户是否存在
     * @param username
     * @return
     */
    StatusVO checkUser(String username);
}
