package com.example.taskmanager.exceptions;

import com.example.taskmanager.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class AccountAlreadyVerifiedException extends RuntimeException{
    public AccountAlreadyVerifiedException() {
        super(ErrorMessages.ACCOUNT_ALREADY_VERIFIED.getMessage());
    }
}
