package com.StudentManagementSystem.Service;

import com.StudentManagementSystem.Dto.CourseRequest;
import com.StudentManagementSystem.Dto.CourseResponse;
import com.StudentManagementSystem.Entity.CourseEntity;
import com.StudentManagementSystem.Repository.CourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseService {

    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public CourseResponse addCourse(CourseRequest courseRequest) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseCode(courseRequest.getCourseCode());
        courseEntity.setCourseName(courseRequest.getCourseName());

        CourseEntity savedCourseEntity = courseRepo.save(courseEntity);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseId(savedCourseEntity.getCourseId());
        courseResponse.setCourseName(savedCourseEntity.getCourseName());
        courseResponse.setCourseCode(savedCourseEntity.getCourseCode());
        return courseResponse;
    }

    public CourseResponse updateCourse(CourseRequest courseRequest,Long courseId) {
        CourseEntity courseEntity = courseRepo.findById(courseId).
                orElseThrow(()-> new RuntimeException("Course not found"));
        courseEntity.setCourseName(courseRequest.getCourseName());
        courseEntity.setCourseCode(courseRequest.getCourseCode());
        CourseEntity savedCourseEntity = courseRepo.save(courseEntity);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseId(savedCourseEntity.getCourseId());
        courseResponse.setCourseName(savedCourseEntity.getCourseName());
        courseResponse.setCourseCode(savedCourseEntity.getCourseCode());
        return courseResponse;
    }

    public String deleteCourse(Long courseId) {
        CourseEntity course=courseRepo.findById(courseId)
                .orElseThrow(()-> new RuntimeException("Course not found"));
        courseRepo.deleteById(courseId);
        return "Course Deleted Successfully";
    }
}
