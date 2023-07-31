package com.microbank.account.application.query;

public record GetAccountQuery(long accountId) {
    public GetAccountQuery {
        if (accountId < 1) {
            throw new IllegalArgumentException("account id cannot be less than 1");
        }
    }
}
