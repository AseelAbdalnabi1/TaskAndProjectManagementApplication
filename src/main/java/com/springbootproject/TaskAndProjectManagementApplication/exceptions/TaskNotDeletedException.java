package com.springbootproject.TaskAndProjectManagementApplication.exceptions;

public class TaskNotDeletedException extends Exception{
    public TaskNotDeletedException(String message) {
        super(message);
    }
}
