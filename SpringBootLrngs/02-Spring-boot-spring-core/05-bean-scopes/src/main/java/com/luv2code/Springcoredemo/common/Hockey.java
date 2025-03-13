package com.luv2code.Springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Hockey implements Coach{

    public Hockey(){
        System.out.println("In constructor : "  + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "This is Hockey";
    }
}
