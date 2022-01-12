package com.example.HandsOnProjectOnJan.service;

import com.example.HandsOnProjectOnJan.payload.StudentDTO;

import java.util.List;

public interface IStudentService {
    public StudentDTO createStudent ( StudentDTO StudentDTO );

    public StudentDTO findByStudentId ( Integer stuId );

    public StudentDTO updateStudent ( Integer stuId, StudentDTO StudentDTO );

    public String deleteStudentId ( Integer id );

    public List< StudentDTO > findAllStudents ( );

}
