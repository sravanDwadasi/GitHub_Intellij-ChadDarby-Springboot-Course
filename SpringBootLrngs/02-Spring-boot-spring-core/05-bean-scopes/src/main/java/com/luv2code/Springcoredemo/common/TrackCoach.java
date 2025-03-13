package com.luv2code.Springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("In constructor : "  + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "This is Track";
    }
}
