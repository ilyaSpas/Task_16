package org.example.projections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    private ResponseEntity<CustomExceptionResponse> handleException(EmployeeNotFoundException e) {
        CustomExceptionResponse response = new CustomExceptionResponse("Employee not founded!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<CustomExceptionResponse> handleException(DepartmentNotFoundException e) {
        CustomExceptionResponse response = new CustomExceptionResponse("Department not founded!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
