package com.rgnrk.pokerplanning.exception;


public class SessionNotFoundException extends RuntimeException {

    private static final String ERROR = "Session with id: %s does not exists. Try to create new one.";

    public SessionNotFoundException(Long sessionId) {
        super(String.format(ERROR, sessionId));
    }
}
