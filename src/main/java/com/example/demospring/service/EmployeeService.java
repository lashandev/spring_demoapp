package com.example.demospring.service;

import com.example.demospring.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    /**
     * This method used to get All Employee data
     * @return List of Employee Data
     */
    List<EmployeeDto> getAll();

    /**
     * This method used to get Employee by code
     * @param code is Employee code
     * @return Employee
     */
    EmployeeDto getEmployee(String code);

    List<EmployeeDto> getEmployebyName(String fname);

    /**
     * this method used to save Employee
     * @param employeeDto
     * @return
     */
    boolean save(EmployeeDto employeeDto);
}
