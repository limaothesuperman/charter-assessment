package com.example.rewards.exception;

public class NullUserException extends RuntimeException {

    public NullUserException(Long customerId) {
        super("User with ID " + customerId + " not found!");
    }
}
