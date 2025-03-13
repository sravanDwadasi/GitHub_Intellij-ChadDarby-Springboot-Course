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

    private Coach anotherCoach;

    private Coach hockeyCoach;
    private Coach anotherhockeyCoach;

    // Define a Constructor for dependency injection
    // Adding extra beans of same instance to check Bean Scopes
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach mycoach,
            @Qualifier("cricketCoach") Coach anotherCoach,
            @Qualifier("hockey") Coach hockeyCoach,
            @Qualifier("hockey") Coach anotherhockeyCoach) {

        this.mycoach = mycoach;
        this.anotherCoach = anotherCoach;

        this.hockeyCoach = hockeyCoach;
        this.anotherhockeyCoach = anotherhockeyCoach;
    }


    @GetMapping("/dailyworkout")
    public String getdailyworkout(){
        return mycoach.getDailyWorkout();
    }

    //Checking Bean Scope if Singleton then "TRUE" because we haven't Scoped the CricketCoach
    // So by default it is "SINGLETON"
    @GetMapping("/check")
    public String check(){
        // We added HockeyCoach where we defined its scope as "PROTOTYPE" so it will create two instance for two injections
        // so the reference of address will be different and gives us "FALSE"
        return "Comparing Beans: mycoach == anotherCoach " + (mycoach == anotherCoach) + "\n" +
                "Comparing Beans: hockeyCoach == anotherhockeyCoach " + (hockeyCoach == anotherhockeyCoach);

    }

}
