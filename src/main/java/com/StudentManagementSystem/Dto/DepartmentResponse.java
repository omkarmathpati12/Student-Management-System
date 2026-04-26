package com.StudentManagementSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private Long departmentId;
    private String departmentName;
    private String departmentCode;
}
