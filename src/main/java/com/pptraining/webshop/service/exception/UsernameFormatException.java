package com.pptraining.webshop.service.exception;

public class UsernameFormatException extends RuntimeException{
    public UsernameFormatException(String message) {
        super(message);
    }
}