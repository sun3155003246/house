package com.sxp.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: likang
 * @Date: 2019/11/5 15:41
 * @Description: 用户实体对象
 */
@Data
public class User {

    private Long userId;//用户ID
    private String username;//用户姓名
    private String email;//邮箱
    private String phone;//手机
    private String password;//密码
    private int status;//用户状态 0-正常 1-封禁
    private Date createTime;//创建时间
    private Date lastLoginTime;//上次登录时间
    private Date lastUpdateTime;//上次更新记录时间
    private String avatar;//头像




}
