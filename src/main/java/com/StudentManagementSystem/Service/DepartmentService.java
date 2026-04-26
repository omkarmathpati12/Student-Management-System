package com.StudentManagementSystem.Service;

import com.StudentManagementSystem.Dto.DepartmentRequest;
import com.StudentManagementSystem.Dto.DepartmentResponse;
import com.StudentManagementSystem.Entity.DepartmentEntity;
import com.StudentManagementSystem.Repository.DepartmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public DepartmentResponse addDepartment(DepartmentRequest departmentRequest){
        DepartmentEntity departmentEntity=new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
        departmentEntity.setDepartmentCode(departmentRequest.getDepartmentCode());

        DepartmentEntity departmentEntity1=departmentRepo.save(departmentEntity);
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setDepartmentId(departmentEntity1.getDepartmentId());
        departmentResponse.setDepartmentName(departmentEntity1.getDepartmentName());
        departmentResponse.setDepartmentCode(departmentEntity1.getDepartmentCode());
        return departmentResponse;
    }
}
