package com.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(nullable = false, unique = true)
    private String departmentName;
    @Column(nullable = false, unique = true)
    private String departmentCode;

    @OneToMany(mappedBy = "department")
    private List<StudentEntity> students;
}
