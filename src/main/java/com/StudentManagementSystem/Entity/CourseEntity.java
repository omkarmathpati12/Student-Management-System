package com.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "course")
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Courses courseName;
    @Column(nullable = false, unique = true)
    private String courseCode;
    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;

    public enum Courses{
        JAVA,
        PYTHON,
        CPP,
        PHP,
        GO
    }
}
