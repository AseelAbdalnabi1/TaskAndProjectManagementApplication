package com.springbootproject.TaskAndProjectManagementApplication.errorhandaling;

import com.springbootproject.TaskAndProjectManagementApplication.models.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> error(Exception exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
