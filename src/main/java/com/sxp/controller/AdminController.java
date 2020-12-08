package com.sxp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/toAdminPage")
    public String toAdminPage(){
        return "admin/adminCenter";
    }
    @GetMapping("/admin/toAdminWelcome")
    public String toWelcomePage(){
        return "admin/welcome";
    }

    /**
     *
     * @return
     */
    @GetMapping("/admin/toAddHousePage")
    public String toAddHousePage(){
        return "admin/houseAdd";
    }

}
