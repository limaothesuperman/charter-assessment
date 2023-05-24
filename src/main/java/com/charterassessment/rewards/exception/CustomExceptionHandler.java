package com.charterassessment.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * Exception handler for the NullUserException.
     * Handles the exception and returns a custom error message with HTTP status code 404 (Not Found).
     *
     * @param ex The NullUserException to handle.
     * @return A string containing the error message.
     */
    @ExceptionHandler(NullUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNullUserException(NullUserException ex) {
        return ex.getMessage();
    }
}
