package com.example.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NullUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNullUserException(NullUserException ex) {
        return ex.getMessage();
    }
}