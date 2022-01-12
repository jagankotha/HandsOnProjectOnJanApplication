package com.example.HandsOnProjectOnJan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {
    private Integer stuId;
    private String stuName;
    private String stuCode;
    private String stuAddr;

}
