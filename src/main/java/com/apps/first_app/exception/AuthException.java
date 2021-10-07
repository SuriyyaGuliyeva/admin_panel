package com.apps.first_app.exception;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
