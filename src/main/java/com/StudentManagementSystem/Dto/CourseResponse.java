package com.StudentManagementSystem.Dto;

import com.StudentManagementSystem.Entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private Long courseId;
    private CourseEntity.Courses name;
    private String courseCode;
}
