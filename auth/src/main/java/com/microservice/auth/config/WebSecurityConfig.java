package com.microservice.auth.config;

import com.microservice.auth.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Alex Liu
 * @date 2022/05/04
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置使用哪个实现类校验用户信息
        auth.userDetailsService(userAuthService);
    }

}
