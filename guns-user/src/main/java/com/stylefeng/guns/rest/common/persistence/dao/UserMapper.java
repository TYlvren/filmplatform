package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.bo.userbo.UserBO;
import com.stylefeng.guns.rest.persistence.model.request.RequestUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-23
 */
public interface UserMapper {


    /**
     * 通过username查找User
     * @param username
     * @return
     */
    UserBO selectUserByUsername(String username);


    /**
     * 通过username和password查找User
     * @param username
     * @param password
     * @return
     */
    UserBO selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int insertUser(RequestUser requestUser);

    int updateUser(UserBO userBO);

    UserBO selectUserByUUID(int uuid);

}