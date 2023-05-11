package com.springbootproject.TaskAndProjectManagementApplication.exceptions;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String message) {
        super(message);
    }
}
