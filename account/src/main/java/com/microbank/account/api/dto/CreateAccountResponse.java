package com.microbank.account.api.dto;

public record CreateAccountResponse(Status status, String message) {
    public static CreateAccountResponse success() {
        Status success = Status.ACCOUNT_CREATED_SUCCESS;
        return new CreateAccountResponse(success, success.message);
    }
}
