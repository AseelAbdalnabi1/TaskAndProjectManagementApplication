package com.springbootproject.TaskAndProjectManagementApplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ErrorMessage {
    private String errorMessage;
    private  int errorCode;
    private HttpStatus status;
    private String description;
}
