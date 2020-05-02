package com.example.springhibernate.springhibernate.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    @Scope("prototype")
    public Test test() {
        return new Test();
    }


    public class Test {

    }
}
