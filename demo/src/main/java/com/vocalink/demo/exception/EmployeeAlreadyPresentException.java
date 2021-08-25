package com.vocalink.demo.exception;

import javax.security.sasl.AuthenticationException;

public class EmployeeAlreadyPresentException extends AuthenticationException {

    public EmployeeAlreadyPresentException (final String message) {
        super(message);
    }
}
