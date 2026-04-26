package com.StudentManagementSystem.Exception;

public class StudentNotFoundException extends IllegalStateException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
