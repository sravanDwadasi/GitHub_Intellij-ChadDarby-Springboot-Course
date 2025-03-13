package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it doesn't need to write any extra lines of codes......
}
