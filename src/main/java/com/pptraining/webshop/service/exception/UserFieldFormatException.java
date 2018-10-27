package com.pptraining.webshop.service.exception;

public class UserFieldFormatException extends RuntimeException {
    public UserFieldFormatException(String fieldName) {
        super(fieldName + " is invalid");
    }
}
