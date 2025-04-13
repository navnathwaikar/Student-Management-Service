package com.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;

    @Column(name = "parentName")
    private String parentName;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "grade")
    private int grade;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "schoolName" )
    private String schoolName;

}
