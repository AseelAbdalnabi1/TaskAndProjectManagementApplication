package com.springbootproject.TaskAndProjectManagementApplication.exceptions;

import com.springbootproject.TaskAndProjectManagementApplication.models.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public final ResponseEntity<ErrorMessage> error(TaskNotFoundException exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,"the required Task is NOT found");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TaskAttachmentToEmployeeException.class)
    public final ResponseEntity<ErrorMessage> error(TaskAttachmentToEmployeeException exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Task is attached to employee");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TaskAttachmentToProjectException.class)
    public final ResponseEntity<ErrorMessage> error(TaskAttachmentToProjectException exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Task is part of the project");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorMessage> error(EntityNotFoundException exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,"NOT FOUND");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TaskCanNotBeCreatedException.class)
    public final ResponseEntity<ErrorMessage> error(TaskCanNotBeCreatedException exception){
        ErrorMessage exceptionResponse = new ErrorMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR,"required task can't be created");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
