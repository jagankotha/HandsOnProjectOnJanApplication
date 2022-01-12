package com.example.HandsOnProjectOnJan.service;

import com.example.HandsOnProjectOnJan.entity.Employee;
import com.example.HandsOnProjectOnJan.payload.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    public EmployeeDTO createEmployee ( EmployeeDTO employeeDTO );

    public EmployeeDTO findByEmployeeId ( Integer empId );

    public EmployeeDTO updateEmployee ( Integer empId, EmployeeDTO employeeDTO );

    public String deleteEmployeeId ( Integer id );

    public List< EmployeeDTO > findAllEmployees ( );

}
