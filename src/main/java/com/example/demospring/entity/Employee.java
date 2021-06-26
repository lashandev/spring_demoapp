package com.example.demospring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @Column(name = "code",unique = true, length = 32,nullable = false)
    private String code;
    @Column(name = "fname", length = 255)
    private String fname;
    @Column(name = "lname")
    private String lname;
}
