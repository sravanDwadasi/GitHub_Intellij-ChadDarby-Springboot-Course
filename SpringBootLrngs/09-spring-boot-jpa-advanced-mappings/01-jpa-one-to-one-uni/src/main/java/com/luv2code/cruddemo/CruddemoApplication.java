package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
		System.out.println("Hello World");

		findInstructor(appDAO);
		};
	}

	private void findInstructor(AppDAO appDAO) {
		
	}


}
