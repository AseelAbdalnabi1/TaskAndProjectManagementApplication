package com.springbootproject.TaskAndProjectManagementApplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorMessage {
    private String errorMessage;
    private  int errorCode;
}
