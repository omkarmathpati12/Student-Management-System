package com.StudentManagementSystem.Repository;

import com.StudentManagementSystem.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<CourseEntity,Long> {
    Optional<CourseEntity> findByName(String name);
}
