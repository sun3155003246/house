package com.sxp.utils;


import com.sxp.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: likang
 * @Date: 2019/11/8 11:24
 * @Description: 用户信息工具类
 */
public class UserInfoUtil {


    /**
    * @Description: 获取用户主键ID
    * @Author: likang
    * @Date: 2019/11/8 11:25
    * @Param: []
    * @Return: java.lang.Long
    * @Exception:
    */
    public static Long  getUserId(){
       return getUser().getUserId();
    }

    /**
    * @Description: 获取用户对象信息
    * @Author: likang
    * @Date: 2019/11/8 11:27
    * @Param: []
    * @Return: com.xdl.entity.User
    * @Exception:
    */
    public static User getUser(){
        //getAuthorities:权限信息
        //getCredentials:认证信息(证书信息)
        //getPrincipal:用户信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof User){
            return (User) principal;
        }
        return null;
    }

}
