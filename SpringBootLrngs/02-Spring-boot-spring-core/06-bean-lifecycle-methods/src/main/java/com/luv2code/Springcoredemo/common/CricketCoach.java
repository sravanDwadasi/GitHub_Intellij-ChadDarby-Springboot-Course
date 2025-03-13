package com.luv2code.Springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor : "  + getClass().getSimpleName());
    }

    // Define our Init Method
    @PostConstruct
    public void doMyStratupStuff(){
        System.out.println("In doMyStrtupStuff(): "  + getClass().getSimpleName());
    }

    // Define our Destroy Method
    @PreDestroy
    public void doMyCleaningStuff(){
        System.out.println("In doMyCleaningStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling!!! Wohooooo";
    }
}
