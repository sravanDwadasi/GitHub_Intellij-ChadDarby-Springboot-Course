package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    //define @PostConstruct to load the stduent data....Only once!

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sravan", "Dwadasi"));
        theStudents.add(new Student("Radha", "Dwadasi"));
        theStudents.add(new Student("Murty", "Dwadasi"));
    }


    //Define endpoint for "/students" - returns a list of students

    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudents;
    }

    // Define an endpoint for "/Students/{StudentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index to the list ... keep it simple for now

        // Check the studentId again list size

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
