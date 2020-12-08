package com.xdl;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


class House33ApplicationTests {


    @Test
    public void test1(){
        //算法加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123123"));
//        System.out.println(encoder.encode("123123"));
        String passwordDB = "$2a$10$tEPaIkC8Zp3lzGhcwXC9Zu2oIQlsHvtQO/2qXsjSWGi0lodlDH.iq";
        //数据库中存储的是：$2a$10$tEPaIkC8Zp3lzGhcwXC9Zu2oIQlsHvtQO/2qXsjSWGi0lodlDH.iq  = 123123
        //用户前端输入密码123123
        // 然后后台接收123123并进行加密：$2a$10$87bIsWBxbIOkXubjA2RvbeJhaUjeI2G/tO95wQdJZN19UHhbp6rvG
        // 将加密结果和数据库做对比
        String inputPassword = "$2a$10$87bIsWBxbIOkXubjA2RvbeJhaUjeI2G/tO95wQdJZN19UHhbp6rvG";
//        if(passwordDB.equals(inputPassword)){
//            System.out.println("true");
//        }
        if(encoder.matches("123123", passwordDB)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }


}
