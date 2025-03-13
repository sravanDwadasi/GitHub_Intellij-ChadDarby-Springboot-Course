package com.luv2code.Springcoredemo.rest;

import com.luv2code.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for the dependency
    private Coach mycoach;



    // Define a Setter for dependency injection
    @Autowired
    public void setMycoach(Coach mycoach) {
        this.mycoach = mycoach;
    }


    @GetMapping("/dailyworkout")
    public String getdailyworkout(){
        return mycoach.getDailyWorkout();
    }
}
