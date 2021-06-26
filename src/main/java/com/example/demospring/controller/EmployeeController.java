package com.example.demospring.controller;

import com.example.demospring.dto.EmployeeDto;
import com.example.demospring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping(value = "/getall")
    public ResponseEntity getAll(){
        List<EmployeeDto> all = employeeService.getAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }
    @GetMapping(value = "/getemployee/{empid}")
    public ResponseEntity getEmployee(@PathVariable String empid){
        if (empid == null || empid.trim().equals(""))
            return new ResponseEntity("Employee Code Empty",HttpStatus.LENGTH_REQUIRED);
        EmployeeDto employee = employeeService.getEmployee(empid);
        if(employee != null)
            return new ResponseEntity(employee, HttpStatus.OK);
        return new ResponseEntity("Employee Doesn't Match",HttpStatus.OK);
    }

    @GetMapping(value = "/getemployeebyname/{fname}")
    public ResponseEntity getEmployeeByName(@PathVariable String fname){
        if (fname == null || fname.trim().equals(""))
            return new ResponseEntity("Employee Code Empty",HttpStatus.LENGTH_REQUIRED);
        List<EmployeeDto> employebyName = employeeService.getEmployebyName(fname);
        if(!employebyName.isEmpty())
            return new ResponseEntity(employebyName, HttpStatus.OK);
        return new ResponseEntity("Employee Doesn't Match",HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.getEmployee(employeeDto.getCode());
        if (employee != null)
            return new ResponseEntity("Employee Already Exsist",HttpStatus.OK);
        boolean save = employeeService.save(employeeDto);
        return new ResponseEntity(save,HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.getEmployee(employeeDto.getCode());
        if (employee == null)
            return new ResponseEntity("Employee Not Exsist",HttpStatus.OK);
        boolean save = employeeService.save(employeeDto);
        return new ResponseEntity(save,HttpStatus.OK);
    }
}
