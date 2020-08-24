package com.babcok.test.exception;

public class EmailExisException extends RuntimeException{
    public EmailExisException(String message) {
        super(message);
    }
}
