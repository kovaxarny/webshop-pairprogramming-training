package com.pptraining.webshop.service.exception;

public class AccountWithEmailAlreadyExistsException extends RuntimeException{
    public AccountWithEmailAlreadyExistsException(String message) {
        super(message);
    }
}
