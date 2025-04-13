package com.example.service;

import com.example.entity.Student;
import com.example.exception.StudentDataNotFoundException;
import com.example.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);


    public Student createStudent(Student student) {

        Student std = studentRepository.save(student);
        logger.info("Student data saved successfully!!");
        return std;
    }

    public List<Student> getAllStudents(){
        logger.info(" Get All Student data!!");

        List<Student> studentList = studentRepository.findAll();
        if(studentList.size() < 1){
            throw new StudentDataNotFoundException("No Data Available for Students");
        }
        return studentList;
    }


    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentDataNotFoundException("No Data availabe for Student ID="+id);
        }
        logger.info("Get Student Data By Id {}",id);
        return student.get();
    }

    public Student updateStudent(Student student) {

        Optional<Student> std = studentRepository.findById(student.getId());
        Student response = null;
        if(std.isPresent()){
            response = studentRepository.save(student);
            logger.info("Student Data Updated Successfully!!!");
        }else {
            logger.error("Student data not found with id={}",student.getId());
            throw new StudentDataNotFoundException("Student data not found with id="+student.getId());
        }
        return response;
    }

    public String deleteStudent(Long id) {

        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.delete(student.get());
            logger.info("Student data Removed with id={}",student.get().getId());
        }else {
            logger.error("Student data Not Found with id={}",id);
            throw new StudentDataNotFoundException("Student data not found with id="+id);
        }
        return "Student Deleted!!";

    }

    @PostConstruct
    public void initData(){

        Student s = new Student(1L,"Navnath","A+","8668816399","Public School");
       // studentRepository.saveAndFlush(s);

        logger.info("PostConstruct method gets called!!");
    }

}
