package com.example.users.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfig {

    @Bean
    public Faker gerFaker() {
        return new Faker();
    }
}
