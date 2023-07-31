package com.microbank.account.api.dto;

public enum Status {
    ACCOUNT_CREATED_SUCCESS("Account Successfully Created"),
    ACCOUNT_DOES_NOT_EXIST(""),
    USER_DOES_NOT_EXIST(""),
    INTERNAL_ERROR("");

    public final String message;

    Status(String message) { this.message = message; }
}
