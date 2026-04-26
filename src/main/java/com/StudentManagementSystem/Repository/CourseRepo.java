package com.StudentManagementSystem.Repository;

import com.StudentManagementSystem.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity,Long> {
}
