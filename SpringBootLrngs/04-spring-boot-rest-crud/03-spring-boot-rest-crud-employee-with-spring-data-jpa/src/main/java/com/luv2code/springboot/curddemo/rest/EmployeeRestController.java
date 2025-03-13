package com.luv2code.springboot.curddemo.rest;

import com.luv2code.springboot.curddemo.entity.Employee;
import com.luv2code.springboot.curddemo.service.EmployeeService;
import com.luv2code.springboot.curddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = (EmployeeServiceImpl) theEmployeeService;
    }


    //Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // Add mapping for GET/Employee/{EmployeeId}
    @GetMapping("/employees/{employeeId}")
    //By Default the PathVariable must be same that is why we too parameter as employeeId.
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException(("Employees id not found - " + employeeId));
        }
        return theEmployee;
    }

    //add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for PUT /employees - Update employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for DELETE /employees - Delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        //find the employee by id
        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        
        employeeService.deleteById(employeeId);

        return "Deleted employee id- " + employeeId;
    }
}
