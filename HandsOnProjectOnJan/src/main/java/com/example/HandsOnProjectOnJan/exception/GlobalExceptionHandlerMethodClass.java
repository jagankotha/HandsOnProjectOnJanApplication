package com.example.HandsOnProjectOnJan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerMethodClass {

    @ExceptionHandler({EmployeeResourceNotFoundException.class, HttpMediaTypeNotSupportedException.class})
//    @ResponseStatus(
//            value = HttpStatus.NOT_FOUND,
//            reason = "Requested employee not found, please look into it..."
//    )
    public ResponseEntity<Error> employeeNotFoundException(EmployeeResourceNotFoundException e){
     Error error = new Error ( HttpStatus.NOT_FOUND,e.getLocalizedMessage () );
     return  new ResponseEntity<> ( error,error.getHttpStatus () );
    }

    @ExceptionHandler(StudentResourceNotFoundException.class)
    public ResponseEntity< Error > studentNotFoundException( StudentResourceNotFoundException e){
        Error error = new Error ( HttpStatus.NOT_FOUND,e.getLocalizedMessage () );
        return new ResponseEntity<> ( error, HttpStatus.EXPECTATION_FAILED );
    }
}
