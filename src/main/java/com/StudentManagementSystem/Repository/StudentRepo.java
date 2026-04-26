package com.StudentManagementSystem.Repository;

import com.StudentManagementSystem.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
