package com.StudentManagementSystem.Repository;

import com.StudentManagementSystem.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findByDepartmentId(Long departmentId);
}
