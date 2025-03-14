package com.luv2code.Springcoredemo.config;

import com.luv2code.Springcoredemo.common.Coach;
import com.luv2code.Springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
