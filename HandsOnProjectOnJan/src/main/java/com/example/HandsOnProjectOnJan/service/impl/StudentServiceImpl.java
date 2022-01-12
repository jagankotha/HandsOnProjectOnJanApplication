package com.example.HandsOnProjectOnJan.service.impl;

import com.example.HandsOnProjectOnJan.entity.Student;
import com.example.HandsOnProjectOnJan.entity.Student;
import com.example.HandsOnProjectOnJan.exception.StudentResourceNotFoundException;
import com.example.HandsOnProjectOnJan.exception.StudentResourceNotFoundException;
import com.example.HandsOnProjectOnJan.payload.StudentDTO;
import com.example.HandsOnProjectOnJan.payload.StudentDTO;
import com.example.HandsOnProjectOnJan.repo.StudentRepository;
import com.example.HandsOnProjectOnJan.repo.StudentRepository;
import com.example.HandsOnProjectOnJan.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    private StudentRepository repository;
    private ModelMapper modelMapper;

    public StudentServiceImpl ( StudentRepository repository, ModelMapper modelMapper ) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO createStudent ( StudentDTO studentDTO ) {
        return mapToDTO ( repository.save ( mapToEntity ( studentDTO ) ) );
    }

    @Override
    public StudentDTO findByStudentId ( Integer stuId ) {
        Student student = repository.findById ( stuId ).orElseThrow ( ( ) -> new StudentResourceNotFoundException ( "Post", "id", stuId ) );
        return mapToDTO ( student );
    }

    @Override
    public StudentDTO updateStudent ( Integer stuId, StudentDTO studentDTO ) {
        Student student = repository.findById ( stuId ).orElseThrow ( ( ) -> new StudentResourceNotFoundException ( "Post", "id", stuId ) );
        // Student Student = mapToEntity ( StudentDTO );
        student.setStuAddr ( studentDTO.getStuAddr ( ) );
        student.setStuName ( studentDTO.getStuName ( ) );
        student.setStuCode ( studentDTO.getStuCode ( ) );
        return mapToDTO ( repository.save ( student ) );
    }

    @Override
    public String deleteStudentId ( Integer id ) {
        Student Student = repository.findById ( id ).orElseThrow ( ( ) -> new StudentResourceNotFoundException ( "Post", "id", id ) );
        repository.delete ( Student );
        return "Student deleted successfully.";
    }

    @Override
    public List< StudentDTO > findAllStudents ( ) {
        List< Student > list = repository.findAll ( );
        List< StudentDTO > dtoList = list.stream ( ).map ( s -> mapToDTO ( s ) ).collect ( Collectors.toList ( ) );
        return dtoList;
    }

    StudentDTO mapToDTO ( Student student ) {
        return modelMapper.map ( student, StudentDTO.class );
    }

    Student mapToEntity ( StudentDTO studentDTO ) {
        return modelMapper.map ( studentDTO, Student.class );
    }

    void display(){
        System.out.println ("hello world programming" );
        System.out.println ("hello world programming" );
        System.out.println ("hello world programming" );
        System.out.println ("hello world programming" );
    }
}
