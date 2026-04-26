package com.StudentManagementSystem.Service;

import com.StudentManagementSystem.Dto.StudentRequest;
import com.StudentManagementSystem.Dto.StudentResponse;
import com.StudentManagementSystem.Entity.CourseEntity;
import com.StudentManagementSystem.Entity.DepartmentEntity;
import com.StudentManagementSystem.Entity.StudentEntity;
import com.StudentManagementSystem.Exception.StudentAlreadyExists;
import com.StudentManagementSystem.Exception.StudentNotFoundException;
import com.StudentManagementSystem.Repository.CourseRepo;
import com.StudentManagementSystem.Repository.DepartmentRepo;
import com.StudentManagementSystem.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepo studentRepo;
    private final DepartmentRepo departmentRepo;
    private final CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, DepartmentRepo departmentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.departmentRepo = departmentRepo;
        this.courseRepo = courseRepo;
    }

    public StudentResponse registerStudent(StudentRequest studentRequest) {
        if(studentRepo.existsByEmail(studentRequest.getEmail())){
            throw new StudentAlreadyExists("Email Already Exists");
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentRequest.getName());
        studentEntity.setEmail(studentRequest.getEmail());
        studentEntity.setPhone(studentRequest.getPhone());
        studentEntity.setGender(studentRequest.getGender());

        DepartmentEntity departmentEntity = departmentRepo.findById(studentRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department Not Found"));
        studentEntity.setDepartment(departmentEntity);


        List<CourseEntity> courseEntity=courseRepo.findAllById(studentRequest.getCourseIds());
        if(courseEntity.isEmpty()){
            throw new RuntimeException("Course Not Found");
        }

        if(courseEntity.size() != studentRequest.getCourseIds().size()){
            throw new RuntimeException("Course Size Mismatch");
        }
        studentEntity.setCourses(courseEntity);




        StudentEntity result = studentRepo.save(studentEntity);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(result.getName());
        studentResponse.setEmail(result.getEmail());
        studentResponse.setPhone(result.getPhone());
        studentResponse.setGender(result.getGender());
        studentResponse.setRegistrationDate(result.getRegistrationDate());
        return studentResponse;
    }
}
