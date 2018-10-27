package com.pptraining.webshop.service.exception;

public class UserFieldNullException extends RuntimeException {
    public UserFieldNullException(String fieldName) {
        super(fieldName + " cannot be null");
    }
}
