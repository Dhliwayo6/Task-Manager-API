package com.example.taskmanager.enums;

public enum ErrorMessages {
    USER_NOT_FOUND("User not found!"),
    ACCOUNT_NOT_VERIFIED("Account not verified, verify account before logging in"),
    EMAIL_ALREADY_EXISTS("The email you entered already exists"),
    INVALID_TOKEN("Invalid token"),
    ACCOUNT_ALREADY_VERIFIED("Account has already been verified"),
    TASK_NOT_FOUND("Task not found"),
    VERIFICATION_TOKEN_EXPIRED("The verification token you entered has expired");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
