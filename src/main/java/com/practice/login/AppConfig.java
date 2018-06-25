package com.practice.login;

import com.practice.login.login.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qinhonglin
 * @date 2018/6/25
 */
@Configuration
public class AppConfig implements WebMvcConfigurer{

    /**
     * 这里必须要public才行
     * @return
     */
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = loginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }
}
