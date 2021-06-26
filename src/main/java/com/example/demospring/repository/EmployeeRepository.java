package com.example.demospring.repository;

import com.example.demospring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    List<Employee> findByFname(String fname);

    List<Employee> findByFnameAndLname(String fname,String lname);

    List<Employee> findByFnameStartingWith(String fname);
}
