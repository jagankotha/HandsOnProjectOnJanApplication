package com.example.HandsOnProjectOnJan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "emp_jwx_marks")
public class Marks {
    private String empJwxName;
    private String empJwxCode;
    private String empJwxState;
    private String empJwxProject;
    private String empJwxMarks;
    private String empJwxCollege;
    private String empJwxCompany;
    private String empJwxStatus;
    private String empJwxPosition;
    private String empJwxCountry;
    private String emp;

}
