package com.luv2code.springboot.curddemo.service;

import com.luv2code.springboot.curddemo.dao.EmployeeRepository;
import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // Setting up the Constructor injection for the EmployeeRepository because instead of specifically creating a new methods
    // We are delighting the EmployeeRepository methods here as they are same we are just handling Transactions(@Transactional)
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        this.employeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    @Override
    public Employee findById(int theId) {
        //"Optional" Different pattern instead of having to check for nulls.
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        
        if(result.isPresent()) theEmployee = result.get();
        else throw new RuntimeException("Did not find the employee id - " + theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployees) {
        return employeeRepository.save(theEmployees);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
