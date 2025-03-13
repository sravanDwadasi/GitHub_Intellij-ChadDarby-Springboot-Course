package com.luv2code.crud_demo.dao;

import com.luv2code.crud_demo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Used for translation between JDBC while implementing DAO
@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for ENTITY Manager]=
    private EntityManager entityManager;

    // Inject Entity manager using Constructor Injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implementing Save Method
    @Override
    //Since we are performing making update on the table we use Transactional annotation
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        //Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //Return Query Results
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findBYLastName(String theLastName) {
        // Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // Set Query Parameter
        theQuery.setParameter("theData", theLastName);

        //Return Query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // Retrieve the Student
        Student theStudent = entityManager.find(Student.class, id);

        // Delete the Student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }


}
