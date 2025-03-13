package com.luv2code.springboot.curddemo.service;

import com.luv2code.springboot.curddemo.dao.EmployeeDAO;
import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // Setting up the Constructor injection for the EmployeeDAO because instead of specifically creating a new methods
    // We are delighting the EmployeeDAO methods here as they are same we are just handling Transactions(@Transactional)
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll(); // Delegating EmployeeDAO Methods here instead of creating as they are same.
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional //Using this here because it is a good practise to use at service layer for better quality and understanding.
    @Override
    public Employee save(Employee theEmployees) {
        return employeeDAO.save(theEmployees);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
