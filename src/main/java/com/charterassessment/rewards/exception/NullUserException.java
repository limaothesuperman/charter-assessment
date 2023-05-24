package com.charterassessment.rewards.exception;

public class NullUserException extends RuntimeException {

    /**
     * Constructs a NullUserException with the given customer ID.
     *
     * @param customerId The ID of the customer that was not found.
     */
    public NullUserException(Long customerId) {
        super("User with ID " + customerId + " not found!");
    }
}
