package com.example.HandsOnProjectOnJan.repo;

import com.example.HandsOnProjectOnJan.entity.Employee;
import com.example.HandsOnProjectOnJan.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository< Student, Integer > {
}
