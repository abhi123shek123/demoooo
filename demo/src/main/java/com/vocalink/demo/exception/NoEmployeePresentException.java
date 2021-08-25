package com.vocalink.demo.exception;

import javax.security.sasl.AuthenticationException;

public class NoEmployeePresentException extends AuthenticationException {

    public NoEmployeePresentException (final String message) {
        super(message);
    }
}
