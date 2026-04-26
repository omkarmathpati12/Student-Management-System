package com.StudentManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleStudentNotFoundException(StudentNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(StudentAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleStudentAlreadyExists(StudentAlreadyExists ex) {
        return ex.getMessage();
    }
}
