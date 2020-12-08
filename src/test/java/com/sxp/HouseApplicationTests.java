package com.sxp;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class HouseApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
        //算法加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println( encoder.encode("123"));
    }
}
