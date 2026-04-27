package com.StudentManagementSystem.Controller;

import com.StudentManagementSystem.Dto.CourseRequest;
import com.StudentManagementSystem.Dto.CourseResponse;
import com.StudentManagementSystem.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseResponse> saveCourse(@Valid @RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.addCourse(courseRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Long id) {
        CourseResponse courseResponse = courseService.updateCourse(courseRequest, id);
        return ResponseEntity.ok(courseResponse);
    }
}
