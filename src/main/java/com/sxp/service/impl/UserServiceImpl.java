package com.sxp.service.impl;

import com.sxp.dao.UserDAO;
import com.sxp.entity.User;
import com.sxp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDAO userDAO;
    @Override
    public User queryUserByUserName(String username) {

        return userDAO.queryUserByUserName(username);
    }
}
