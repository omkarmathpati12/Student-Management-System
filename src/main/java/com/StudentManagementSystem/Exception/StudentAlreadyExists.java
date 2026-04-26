package com.StudentManagementSystem.Exception;

public class StudentAlreadyExists extends RuntimeException{
    public StudentAlreadyExists(String message) {
        super(message);
    }
}
