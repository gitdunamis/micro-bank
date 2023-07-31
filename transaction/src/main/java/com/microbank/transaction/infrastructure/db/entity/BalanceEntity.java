package com.microbank.transaction.infrastructure.db.entity;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BalanceEntity extends Entity {
    long accountId;
    BigDecimal balance;

    public BalanceEntity(long id, long accountId, BigDecimal balance) {
        this.id = id;
        this.accountId = accountId;
        this.balance = balance;
    }
}
