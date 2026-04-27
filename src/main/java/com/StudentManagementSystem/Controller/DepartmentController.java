package com.StudentManagementSystem.Controller;

import com.StudentManagementSystem.Dto.DepartmentRequest;
import com.StudentManagementSystem.Dto.DepartmentResponse;
import com.StudentManagementSystem.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentResponse> addDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        DepartmentResponse departmentResponse = departmentService.addDepartment(departmentRequest);
        return ResponseEntity.ok(departmentResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@Valid @RequestBody DepartmentRequest departmentRequest, @PathVariable Long id) {
        DepartmentResponse departmentResponse = departmentService.updateDepartment(departmentRequest, id);
        return ResponseEntity.ok(departmentResponse);
    }
}
