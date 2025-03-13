package com.luv2code.crud_demo;

import com.luv2code.crud_demo.dao.StudentDAO;
import com.luv2code.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	//CommandLineRunner is used to execute after the Spring Beans are loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		//Lambda expression
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students..... ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted no of Rows: " + numRowsDeleted);


	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentid = 3;
		System.out.println("Deleting Student with Id: " + studentid);
		studentDAO.delete(studentid);

	}

	private void updateStudent(StudentDAO studentDAO) {

		//Retrieve Student based on the ID: Primary key
		int studentId = 1;
		System.out.println("Getting Student with Id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//Change the First Name to Scooby
		System.out.println("Updating Student....");
		myStudent.setFirstName("charlie");


		//Update the Student
		studentDAO.update(myStudent);


		//Display the Student
		System.out.println("Updated Student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get the List of Students
		List<Student> theStudents = studentDAO.findBYLastName("Seelam");

		//display list of Students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get a list of Students
		List<Student> theStudents = studentDAO.findAll();

		//Display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//Create a Student object
		System.out.println("Creating new Student Object....");
		Student tempStudent = new Student("Sravan", "Dwadasi", "Sravan@gmail.com");

		//save the Student
		System.out.println("Saving the Student....");
		studentDAO.save(tempStudent);

		//Display the Id of the Student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated Id: " + theId);

		//Retrieve Student based on the id: primary key
		System.out.println("Retriving the Student with the given Id: " + theId);
		Student mystudent = studentDAO.findById(theId);

		//Display student
		System.out.println("Found the Student: " + mystudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//Create multiple Students
		System.out.println("Creating multiple student object ...");
		Student tempStudent1 = new Student("Sravan", "Dwadasi", "Sravan@gmail.com");
		Student tempStudent2 = new Student("Anu", "Dwadasi", "anu@gmail.com");
		Student tempStudent3= new Student("Murty", "Dwadasi", "murty@gmail.com");
		Student tempStudent4 = new Student("Ram", "Seelam", "ram@gmail.com");

		//Save the student objects
		System.out.println("Saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Sravan", "Dwadasi", "Sravan@gmail.com");

		//Save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		System.out.println("Saved stduent. Generated id: " + tempStudent.getId());



	}

}
