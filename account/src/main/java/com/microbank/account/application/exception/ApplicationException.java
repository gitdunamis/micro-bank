package com.microbank.account.application.exception;

public sealed abstract class ApplicationException extends RuntimeException {
    private ApplicationException(String message) {
        super(message);
    }
    public static final class AccountNotFoundException extends ApplicationException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    public static final class UserNotFoundException extends ApplicationException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static final class AccountCreationFailedExecption extends ApplicationException {
        public AccountCreationFailedExecption(String message) {
            super(message);
        }
    }


}
