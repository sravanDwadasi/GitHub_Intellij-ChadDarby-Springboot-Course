package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImple implements EmployeeDAO{

    //Define field for entitymanager
    private EntityManager entityManager;

    //Set up constructor Injection
    @Autowired
    public EmployeeDAOJpaImple(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        //Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //Get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Return theEmployee
        return theEmployee;
    }

    //If you can see here we are not using "@Transactional" annotation because it best method not implementing that
    //at DAO layer and handling it at "Service Layer".
    // Same with all the Transactions.
    @Override
    public Employee save(Employee theEmployee) {

        //Save Employees
        Employee dbEmployee = entityManager.merge(theEmployee);
        //Usually when we use Merge then if the id == 0 then it inserts the element or else it updates the element.

        //return the dbEmplyoee
        return dbEmployee;
        //Here when we return dbEmployee we will get the Latest ID of the updated element.
    }

    //No @Transactional annotation because transactions are handled in Service layer.
    @Override
    public void deleteById(int theId) {

        //Find employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Remove employee
        entityManager.remove(theEmployee);
    }

}
