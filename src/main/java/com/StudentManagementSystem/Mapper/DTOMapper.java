package com.StudentManagementSystem.Mapper;

import com.StudentManagementSystem.Dto.StudentResponse;
import com.StudentManagementSystem.Entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {

    public StudentResponse mapToResponse(StudentEntity student){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setPhone(student.getPhone());
        studentResponse.setGender(student.getGender());
        studentResponse.setRegistrationDate(student.getRegistrationDate());
        return studentResponse;
    }
}
