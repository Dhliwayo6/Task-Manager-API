package com.example.taskmanager.exceptions;

import com.example.taskmanager.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class VerificationTokenExpiredException extends  RuntimeException{
    public VerificationTokenExpiredException() {
        super(ErrorMessages.VERIFICATION_TOKEN_EXPIRED.getMessage());
    }
}
