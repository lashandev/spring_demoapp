package com.example.demospring.service.impl;

import com.example.demospring.dto.EmployeeDto;
import com.example.demospring.entity.Employee;
import com.example.demospring.repository.EmployeeRepository;
import com.example.demospring.service.CommonService;
import com.example.demospring.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CommonService commonService;
    /**
     * This method used to get All Employee data
     *
     * @return List of Employee Data
     */
    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> returnList = new ArrayList<>();
        List<Employee> all = employeeRepository.findAll();
        all.stream().forEach(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setCode(employee.getCode());
            employeeDto.setFname(employee.getFname());
            employeeDto.setLname(employee.getLname());
            returnList.add(employeeDto);
        });
        return returnList;
    }

    /**
     * This method used to get Employee by code
     *
     * @param code is Employee code
     * @return Employee
     */
    @Override
    public EmployeeDto getEmployee(String code) {
        Optional<Employee> byId = employeeRepository.findById(code);
        Employee employee = byId.orElse(null);
        EmployeeDto employeeDto = null;
        if (employee != null) {
            employeeDto = (EmployeeDto) commonService.modelConvert(employee, EmployeeDto.class);
        }
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getEmployebyName(String fname) {
        ModelMapper modelMapper = new ModelMapper();
        List<EmployeeDto> returnList = new ArrayList<>();
        List<Employee> list = employeeRepository.findByFnameStartingWith(fname);
        list.stream().forEach(employee -> {
            EmployeeDto employeeDto = (EmployeeDto) commonService.modelConvert(employee, EmployeeDto.class);
            returnList.add(employeeDto);
        });
        return returnList;
    }

    /**
     * this method used to save Employee
     *
     * @param employeeDto
     * @return
     */
    @Override
    public boolean save(EmployeeDto employeeDto) {
        boolean issave = false;
        Employee employee = (Employee) commonService.modelConvert(employeeDto,Employee.class);
        Employee save = employeeRepository.save(employee);
        if (save != null)
            issave = true;
        return issave;
    }
}
