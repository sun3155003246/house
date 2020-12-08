package com.sxp.security;


import com.sxp.entity.User;
import com.sxp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyAuthenticationProvider  implements AuthenticationProvider {

    //非对称加密算法BCRY
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    IUserService userService;
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        //获取用户输入的用户名
        String inputName = auth.getName();
        //获取用户输入的密码
        String inputPassword = (String) auth.getCredentials();
        User user = userService.queryUserByUserName(inputName);
        if(user == null){
            throw new BadCredentialsException("authError");
        }
        if(encoder.matches(inputPassword,user.getPassword())){
            return new UsernamePasswordAuthenticationToken(user, null, null);
        }
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
