package com.microbank.account.api.controller.dto;

import com.microbank.account.domain.entity.Account;

import static com.microbank.account.domain.entity.Account.AccountType;


public record GetAccountResponse(long accountId, AccountType type, long userId) {

    public static GetAccountResponse from(Account account) {
        AccountType type = account.getType();
        long userId = account.getUserId().id();
        long accountId = account.getId().id();

        return new GetAccountResponse(accountId, type, userId);
    }
}
