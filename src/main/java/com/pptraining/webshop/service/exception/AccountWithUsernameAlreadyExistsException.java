package com.pptraining.webshop.service.exception;

public class AccountWithUsernameAlreadyExistsException extends RuntimeException{
    public AccountWithUsernameAlreadyExistsException(String message) {
        super(message);
    }
}