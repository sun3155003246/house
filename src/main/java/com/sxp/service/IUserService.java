package com.sxp.service;

import com.sxp.entity.User;

/**
 * @Author: sunxinpeng
 * @Date:2020/07/07
 * @Description:用户模块接口
 */
public interface IUserService {

    /**
     * @Description:根据用户名查询用户信息
     * @Author:sunxinpeng
     * @param username
     * @return
     */
    User queryUserByUserName(String username);
}
