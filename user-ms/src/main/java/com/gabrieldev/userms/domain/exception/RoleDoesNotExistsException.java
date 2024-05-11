package com.gabrieldev.userms.domain.exception;

public class RoleDoesNotExistsException extends RuntimeException{

    public RoleDoesNotExistsException(String message) {
        super(message);
    }
}

