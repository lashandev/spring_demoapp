package com.example.demospring.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private String code;
    private StatusDto status;
    private String description;
}
