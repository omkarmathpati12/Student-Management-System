package com.StudentManagementSystem.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    @NotBlank
    private String departmentName;
    @NotBlank
    private String departmentCode;
}
