package com.example.HandsOnProjectOnJan.controller;

import com.example.HandsOnProjectOnJan.payload.StudentDTO;
import com.example.HandsOnProjectOnJan.payload.StudentDTO;
import com.example.HandsOnProjectOnJan.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/student" )
public class StudentController {


    private ModelMapper mapper;

    private IStudentService service;

    public StudentController ( ModelMapper mapper, IStudentService service ) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping ( "/v1/Students" )
    public StudentDTO createStudent ( @RequestBody StudentDTO studentDTO ) {
        return service.createStudent ( studentDTO );
    }

    @GetMapping ( "/v1/students/{stuId}" )
    public StudentDTO getBystuId ( @PathVariable Integer stuId ) {
        return service.findByStudentId ( stuId );
    }

    @GetMapping ( "/v1/students/all" )
    public List< StudentDTO > getAllStudents ( ) {
        return service.findAllStudents ( );
    }

    @PutMapping ( "/v1/students/{stuId}" )
    public StudentDTO updateStudent ( @PathVariable Integer stuId, @RequestBody StudentDTO StudentDTO ) {
        return service.updateStudent ( stuId, StudentDTO );
    }

    @DeleteMapping ( "/v1/students/{stuId}" )
    public String deleteStudent ( @PathVariable Integer stuId ) {
        return service.deleteStudentId ( stuId );
    }
}
