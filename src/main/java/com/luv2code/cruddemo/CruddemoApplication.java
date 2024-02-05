package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.luv2code.cruddemo.dao.StudentRepository;

@SpringBootApplication
public class CruddemoApplication {

	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return runner->{
			createStudent(studentRepository);
		};
	}
	private void createStudent(StudentRepository studentRepository) {
		//create student object
		
	}

}
