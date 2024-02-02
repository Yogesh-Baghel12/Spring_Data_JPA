package com.luv2code.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }
    
    @GetMapping("/students")
    public List<Student> findall() {
        return studentService.findall();
    }

    @GetMapping("/students/{studentsId}")
    public Student getStudent(@PathVariable int studentsId) {
        Student thStudent=studentService.findById(studentsId);
        if(thStudent==null){
            throw new RuntimeException("Employee not found --"+studentsId);
        }
        return thStudent;
    }
    
    //Add student or save
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student thStudent) {
        
        thStudent.setId(0);
        Student dbStudent=studentService.save(thStudent);
        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student thStudent) {
        Student dbStudent=studentService.save
        (thStudent);
        return dbStudent;
    }
    
    @DeleteMapping("/students/{studentID}")
    public String deletestudent(@PathVariable int studentID){
        Student temp=studentService.findById(studentID);
        if(temp==null){
            throw new RuntimeException("Student not found"+studentID);
        }
        studentService.deleteById(studentID);
        return "Deleted Student: "+temp.getFirstName()+" "+temp.getLastName()+" "
        
        +temp.getEmail();
    }

}
