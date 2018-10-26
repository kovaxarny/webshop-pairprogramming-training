package com.pptraining.webshop.service.exception;

public class EmailFormatException extends RuntimeException{
    public EmailFormatException(String message) {
        super(message);
    }
}