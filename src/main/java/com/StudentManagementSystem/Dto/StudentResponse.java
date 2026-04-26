package com.StudentManagementSystem.Dto;

import com.StudentManagementSystem.Entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private String name;
    private String email;
    private String phone;
    private StudentEntity.Gender gender;
    private LocalDateTime registrationDate;
}
