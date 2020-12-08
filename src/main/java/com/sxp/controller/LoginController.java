package com.sxp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@Controller
public class LoginController {
    @GetMapping("/user/toUserLogin")
    public String toLoginPage(){
        //begin sunxinpeng 2020年6月27日21:24:05 == TODO 原因
        return "user/login";
    }

}
