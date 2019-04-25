package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;


public interface UserService {

    boolean register(RequestUser requestUser);

    /**
     * 通过用户名检查用户是否存在
     * @param username
     * @return
     */
    boolean checkUser(String username);

    /**
     * 通过用户名和密码查找用户是否存在
     * @param username
     * @param password
     * @return
     */
    boolean findUser(String username,String password);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    UserBO findUser(String username);

    /**
     * 修改用户信息
     * @param userBO
     * @return
     */
    boolean updateUser(UserBO userBO);

    /**
     * 通过UUID查找用户
     * @param uuid
     * @return
     */
    UserBO findUser(int uuid);
}
