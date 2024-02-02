package com.luv2code.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.dao.StudentRepository;
import com.luv2code.cruddemo.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
     
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository theStudentRepository){
        studentRepository = theStudentRepository; 
    }

    @Override
    public List<Student> findAll(){
        return  studentRepository.findAll();  

    }
     

    @Override
    public Student findById(int theid) {
        Optional<Student> result=studentRepository.findById(theid);
        Student theStudent = null;
        if(result.isPresent()){
            theStudent =result.get();
        }
        else{
            throw new RuntimeException("Did not find a student with id "+theid);
        }
        return theStudent;
    }
     
    
    @Override
    public Student save(Student theStudent) {
       return   studentRepository.save(theStudent);
    }
    
    
    @Override
    public void deleteById(int theid) {
        
        studentRepository.deleteById(theid);
    }
}
