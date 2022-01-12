package com.example.HandsOnProjectOnJan.service.impl;

import com.example.HandsOnProjectOnJan.entity.Employee;
import com.example.HandsOnProjectOnJan.exception.EmployeeResourceNotFoundException;
import com.example.HandsOnProjectOnJan.payload.EmployeeDTO;
import com.example.HandsOnProjectOnJan.repo.EmployeeRepository;
import com.example.HandsOnProjectOnJan.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository repository;
    private ModelMapper modelMapper;

    public EmployeeServiceImpl ( EmployeeRepository repository, ModelMapper modelMapper ) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO createEmployee ( EmployeeDTO employeeDTO ) {
        return mapToDTO ( repository.save ( mapToEntity ( employeeDTO ) ) );
    }

    @Override
    public EmployeeDTO findByEmployeeId ( Integer empId ) {
        Employee employee = repository.findById ( empId ).orElseThrow ( ( ) -> new EmployeeResourceNotFoundException ( "Post", "id", empId ) );
        return mapToDTO ( employee );
    }

    @Override
    public EmployeeDTO updateEmployee ( Integer empId, EmployeeDTO employeeDTO ) {
        Employee employee = repository.findById ( empId ).orElseThrow ( ( ) -> new EmployeeResourceNotFoundException ( "Post", "id", empId ) );
        // Employee employee = mapToEntity ( employeeDTO );
        employee.setEmpAddr ( employeeDTO.getEmpAddr ( ) );
        employee.setEmpCode ( employeeDTO.getEmpCode ( ) );
        employee.setEmpName ( employeeDTO.getEmpCode ( ) );
        return mapToDTO ( repository.save ( employee ) );
    }

    @Override
    public String deleteEmployeeId ( Integer id ) {
        Employee employee = repository.findById ( id ).orElseThrow ( ( ) -> new EmployeeResourceNotFoundException ( "Post", "id", id ) );
        repository.delete ( employee );
        return "employee deleted successfully.";
    }

    @Override
    public List< EmployeeDTO > findAllEmployees ( ) {
        List< Employee > list = repository.findAll ( );
        List< EmployeeDTO > dtoList = list.stream ( ).map ( s -> mapToDTO ( s ) ).collect ( Collectors.toList ( ) );
        return dtoList;
    }

    EmployeeDTO mapToDTO ( Employee employee ) {
        return modelMapper.map ( employee, EmployeeDTO.class );
    }

    Employee mapToEntity ( EmployeeDTO employeeDTO ) {
        return modelMapper.map ( employeeDTO, Employee.class );
    }
}
