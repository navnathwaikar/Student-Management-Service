package com.example.controller;


import com.example.entity.Student;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        logger.info("Save Student Data started!!");
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));

    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        logger.info("Retrieving All Student Data!!");
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        logger.info("Student Details Found with Id={}", id);
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudentById(id));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student response = studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body((response));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        String response = studentService.deleteStudent(id);
        return ResponseEntity.ok(response);
    }

}
