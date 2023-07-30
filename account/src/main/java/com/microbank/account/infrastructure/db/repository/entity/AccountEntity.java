package com.microbank.account.infrastructure.db.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.microbank.account.domain.entity.Account.AccountType;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class AccountEntity extends Entity {
    private long userId;
    AccountType accountType;

    public AccountEntity(long userId, AccountType accountType, long entityId) {
        this.userId = userId;
        this.accountType = accountType;
        this.id = entityId;
    }
}

