package com.sxp.dao;


import com.sxp.entity.User;

public interface UserDAO {
    /**
     * @Description:根据用户名查询用户信息
     * @Author:sunxinpeng
     * @param username
     * @return
     */
    User queryUserByUserName(String username);
}
