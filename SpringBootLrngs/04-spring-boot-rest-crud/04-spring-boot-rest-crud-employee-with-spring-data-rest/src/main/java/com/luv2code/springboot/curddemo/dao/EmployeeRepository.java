package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it doesn't need to write any extra lines of codes......
}
