package com.microbank.transaction.application.query;

public record GetBalanceQuery(long accountId) {
    public GetBalanceQuery {
        if (accountId <= 0) {
            throw new IllegalArgumentException("Account Id cannot be less than 1");
        }
    }
}
