package com.microbank.transaction.api.dto;

import com.microbank.transaction.domain.entity.Balance;

import java.math.BigDecimal;

public record BalanceResponse(long accountId, BigDecimal balance) {
    public static BalanceResponse from(Balance balance) {
        return new BalanceResponse(balance.getAccountId().id(), balance.getValue().value());
    }
}
