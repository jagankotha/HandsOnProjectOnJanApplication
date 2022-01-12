package com.example.HandsOnProjectOnJan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table",uniqueConstraints = {@UniqueConstraint  ( columnNames = "empCode")})
public class Employee {

    private RestTemplateBuilder builder;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empCode;
    private String empName;
    private String empAddr;

}
