package com.telusko.BlogApp.config;


import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       return http.build();

    }

    public void test(){
        System.out.println("this is test");
    }



}
