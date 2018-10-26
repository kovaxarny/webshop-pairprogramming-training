package com.pptraining.webshop.service.exception;

public class InvalidZipCodeException extends RuntimeException{
    public InvalidZipCodeException(String message) {
        super(message);
    }
}
