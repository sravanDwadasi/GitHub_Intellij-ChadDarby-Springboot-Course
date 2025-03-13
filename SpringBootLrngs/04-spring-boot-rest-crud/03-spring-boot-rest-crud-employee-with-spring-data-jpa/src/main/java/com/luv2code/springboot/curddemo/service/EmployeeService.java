package com.luv2code.springboot.curddemo.service;

import com.luv2code.springboot.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployees);

    void deleteById(int theId);
}
