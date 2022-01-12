package com.example.HandsOnProjectOnJan.controller;

import com.example.HandsOnProjectOnJan.payload.EmployeeDTO;
import com.example.HandsOnProjectOnJan.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/employee" )
public class EmployeeController {


    private ModelMapper mapper;

    private IEmployeeService service;

    public EmployeeController ( ModelMapper mapper, IEmployeeService service ) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping ( "/v1/employees" )
    public EmployeeDTO createEmployee ( @RequestBody EmployeeDTO employeeDTO ) {
        return service.createEmployee ( employeeDTO );
    }

    @GetMapping ( "/v1/employees/{empId}" )
    public EmployeeDTO getByEmpId ( @PathVariable Integer empId ) {
        return service.findByEmployeeId ( empId );
    }

    @GetMapping ( "/v1/employees/all" )
    public List< EmployeeDTO > getAllEmployees ( ) {
        return service.findAllEmployees ( );
    }

    @PutMapping("/v1/employees/{empId}")
    public EmployeeDTO updateEmployee(@PathVariable Integer empId,@RequestBody EmployeeDTO employeeDTO){
        return service.updateEmployee (empId, employeeDTO );
    }

    @DeleteMapping("/v1/employees/{empId}")
    public String deleteEmployee(@PathVariable Integer empId){
        return service.deleteEmployeeId ( empId );
    }



}
