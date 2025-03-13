package com.luv2code.Springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling!!!";
    }
}
