package com.StudentManagementSystem.Dto;

import com.StudentManagementSystem.Entity.CourseEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotNull
    private CourseEntity.Courses name;
    @NotBlank
    private String courseCode;
}
