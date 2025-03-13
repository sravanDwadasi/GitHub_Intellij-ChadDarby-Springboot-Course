package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    // New DAO Methods
    Employee findById(int theId);

    Employee save(Employee theEmployees);

    void deleteById(int theId);
}


