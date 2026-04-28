package com.StudentManagementSystem.Service;

import com.StudentManagementSystem.Dto.StudentRequest;
import com.StudentManagementSystem.Dto.StudentResponse;
import com.StudentManagementSystem.Entity.CourseEntity;
import com.StudentManagementSystem.Entity.DepartmentEntity;
import com.StudentManagementSystem.Entity.StudentEntity;
import com.StudentManagementSystem.Exception.DepartmentNotFoundException;
import com.StudentManagementSystem.Exception.StudentAlreadyExists;
import com.StudentManagementSystem.Exception.StudentNotFoundException;
import com.StudentManagementSystem.Repository.CourseRepo;
import com.StudentManagementSystem.Repository.DepartmentRepo;
import com.StudentManagementSystem.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
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

    public String updateStudent(Long id,StudentRequest studentRequest) {
        StudentEntity student=studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));

        if(studentRequest.getName()!=null){
            student.setName(studentRequest.getName());
        }
        if(studentRequest.getEmail()!=null){
            student.setEmail(studentRequest.getEmail());
        }
        if(studentRequest.getPhone()!=null){
            student.setPhone(studentRequest.getPhone());
        }

        if(studentRequest.getDepartmentId()!=null){
            DepartmentEntity department=departmentRepo.findById(studentRequest.getDepartmentId())
                    .orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
            student.setDepartment(department);
        }
        if(studentRequest.getCourseIds()!=null && !studentRequest.getCourseIds().isEmpty()){
            List<CourseEntity> courseEntities=courseRepo.findAllById(studentRequest.getCourseIds());
            if(courseEntities.size()!=studentRequest.getCourseIds().size()){
                throw new RuntimeException("Course Size Mismatch");
            }
            student.setCourses(courseEntities);
        }

        StudentEntity result = studentRepo.save(student);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(result.getName());
        studentResponse.setEmail(result.getEmail());
        studentResponse.setPhone(result.getPhone());
        studentResponse.setGender(result.getGender());
        studentResponse.setRegistrationDate(result.getRegistrationDate());
        return "Student Updated Successfully";

    }

    public String deleteStudent(Long id){
        StudentEntity student=studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        studentRepo.delete(student);
        return "Student Deleted Successfully";
    }

    public StudentResponse getStudent(Long id){
        StudentEntity student = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setPhone(student.getPhone());
        studentResponse.setGender(student.getGender());
        studentResponse.setRegistrationDate(student.getRegistrationDate());
        return studentResponse;
    }

    public List<StudentResponse> getStudents(){
        List<StudentEntity> student = studentRepo.findAll();
        List<StudentResponse> studentResponse=new ArrayList<>();
        for(StudentEntity studentEntity:student){
            StudentResponse response=new StudentResponse();
            response.setName(studentEntity.getName());
            response.setEmail(studentEntity.getEmail());
            response.setPhone(studentEntity.getPhone());
            response.setGender(studentEntity.getGender());
            response.setRegistrationDate(studentEntity.getRegistrationDate());
            studentResponse.add(response);
        }
        return studentResponse;
    }

    public Page<StudentResponse> getStudents(int page, int size){
        Page<StudentEntity> student = studentRepo.findAll(PageRequest.of(page, size));
        List<StudentResponse> studentResponse=new ArrayList<>();
        for(StudentEntity studentEntity:student){
            StudentResponse response=new StudentResponse();
            response.setName(studentEntity.getName());
            response.setEmail(studentEntity.getEmail());
            response.setPhone(studentEntity.getPhone());
            response.setGender(studentEntity.getGender());
            response.setRegistrationDate(studentEntity.getRegistrationDate());
            studentResponse.add(response);
        }
        return new PageImpl<>(studentResponse, PageRequest.of(page, size), student.getTotalElements());
    }

}
