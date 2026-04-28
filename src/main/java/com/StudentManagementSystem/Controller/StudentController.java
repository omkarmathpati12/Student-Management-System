package com.StudentManagementSystem.Controller;

import com.StudentManagementSystem.Dto.StudentRequest;
import com.StudentManagementSystem.Dto.StudentResponse;
import com.StudentManagementSystem.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable Long id) {
        java.lang.String response = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        String response = studentService.deleteStudent(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        StudentResponse response=studentService.getStudent(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAllStudents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(studentService.getStudents(page, size));
    }

    @GetMapping("/{courseName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseName(@PathVariable String courseName) {
        return ResponseEntity.ok(studentService.getAllStudentCourses(courseName));
    }
}
