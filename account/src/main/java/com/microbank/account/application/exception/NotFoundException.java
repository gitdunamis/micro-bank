package com.microbank.account.application.exception;

public sealed abstract class NotFoundException extends RuntimeException {
    private NotFoundException(String message) {
        super(message);
    }
    public static final class AccountNotFoundException extends NotFoundException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    public static final class UserNotFoundException extends NotFoundException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
