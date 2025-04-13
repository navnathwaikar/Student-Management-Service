package com.example;

import com.example.entity.Student;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class StudentManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementServiceApplication.class, args);

	}




}
