package com.luv2code.cruddemo.service;


import java.util.List;

import  com.luv2code.cruddemo.entity.Student;

public interface StudentService {
    
    List <Student> findAll();
    Student findById(int theid);
	Student save(Student theStudent);
	void deleteById(int theid);
    

}
