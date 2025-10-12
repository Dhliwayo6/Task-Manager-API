package com.example.taskmanager.exceptions;

import com.example.taskmanager.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException() {
        super(ErrorMessages.TASK_NOT_FOUND.getMessage());
    }
}
