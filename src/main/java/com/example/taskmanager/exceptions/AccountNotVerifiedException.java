package com.example.taskmanager.exceptions;

import com.example.taskmanager.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccountNotVerifiedException extends RuntimeException{
    public AccountNotVerifiedException() {
        super(ErrorMessages.ACCOUNT_NOT_VERIFIED.getMessage());
    }
}
