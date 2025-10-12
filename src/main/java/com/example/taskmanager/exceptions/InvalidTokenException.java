package com.example.taskmanager.exceptions;

import com.example.taskmanager.enums.ErrorMessages;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String message) {
        super(ErrorMessages.INVALID_TOKEN.getMessage());
    }
}
