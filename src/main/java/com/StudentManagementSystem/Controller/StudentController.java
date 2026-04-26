package com.StudentManagementSystem.Controller;

import com.StudentManagementSystem.Dto.StudentRequest;
import com.StudentManagementSystem.Dto.StudentResponse;
import com.StudentManagementSystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentResponse> registerStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.registerStudent(studentRequest);
        return ResponseEntity.ok(studentResponse);
    }
}
