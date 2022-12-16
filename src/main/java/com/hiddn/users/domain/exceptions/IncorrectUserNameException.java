package com.hiddn.users.domain.exceptions;

public class IncorrectUserNameException extends Exception {
    public IncorrectUserNameException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
