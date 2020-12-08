package com.sxp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity//启用安全框架
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//默认所有的http请求，都是认证的
                /**
                 *antMatchers:匹配接口地址http是否和参数一致
                 *  参数值：支持表达式
                 *      0：则说明接下来的接口地址，只能是数值
                 *      *： 则说明接下来的接口地址，后面只有1级
                 *      **：则说明接下来的接口地址，后面可以有N级
                 *
                 *permitAll：允许所有的角色都可以访问(不拦截)
                 *anyRequest：拦截所有的请求
                 * authenticated：判断http请求是否授权(角色)
                 * and：一个业务的结束
                 * hasRole:当前http请求，只允许参数值ADMIN访问
                 * hasAnyRole:当前http请求，允许多个角色访问
                 */
                .antMatchers("/user/toUserLogin").permitAll()
//              .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureHandler(authFailureHandler())//自定义异常信息处理（在当前页面提示错误信息）
                .and()
                .logout()//退出功能
                .logoutSuccessUrl("/user/toUserLogin")//退出成功后的跳转地址
                .and()
                .httpBasic();
        http.csrf().disable();//网站伪造(防止恶意攻击的)
        http.headers().frameOptions().sameOrigin();
    }
    @Bean
    public MyAuthenticationFailureHandler authFailureHandler() {

        return new MyAuthenticationFailureHandler();

    }

    @Autowired
    public void configureConfig(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("java33")
//                .password(new BCryptPasswordEncoder().encode("123123")).roles("ADMIN");
        //动态验证用户信息
        auth.authenticationProvider(authProvider());
    }
    @Bean
    public MyAuthenticationProvider authProvider() {
        //验证业务信息
        return new MyAuthenticationProvider();
    }
}
