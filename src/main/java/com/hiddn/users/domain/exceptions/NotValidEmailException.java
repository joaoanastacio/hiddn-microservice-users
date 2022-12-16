package com.hiddn.users.domain.exceptions;

public class NotValidEmailException extends Exception {
    public NotValidEmailException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
