package com.rgnrk.pokerplanning.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String ERROR = "User not found. Check credentials pls.";

    public UserNotFoundException() {
        super(ERROR);
    }
}
