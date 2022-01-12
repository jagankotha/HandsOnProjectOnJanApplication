package com.example.HandsOnProjectOnJan.repo;

import com.example.HandsOnProjectOnJan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository< Employee, Integer > {
}
