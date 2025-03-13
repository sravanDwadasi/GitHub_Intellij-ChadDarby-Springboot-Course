package com.luv2code.Springcoredemo.rest;

import com.luv2code.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for the dependency
    private Coach mycoach;


    // Define a Constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("hockey") Coach mycoach) {
        System.out.println("In constructor : "  + getClass().getSimpleName());
        this.mycoach = mycoach;
    }


    @GetMapping("/dailyworkout")
    public String getdailyworkout(){
        return mycoach.getDailyWorkout();
    }
}
