package com.StudentManagementSystem.Dto;

import com.StudentManagementSystem.Entity.StudentEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "name is required")
    private String name;
    @Email
    private String email;
    @NotBlank
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String phone;
    @NotBlank
    private StudentEntity.Gender gender;
    private Long departmentId;
    private List<Long> courseIds;
}
