package com.microbank.account.domain.entity;

import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Account {
    Id id;

    @Getter final UserId userId;

    @Getter final AccountType type;

    public Account(UserId userId, AccountType accountType) {
        Objects.requireNonNull(userId);
        Objects.requireNonNull(accountType);

        this.userId = userId;
        this.type = accountType;
    }

    public static Account from(long userId, AccountType accountType) {
        return new Account(new UserId(userId), accountType);
    }

    public void addId(Id id) {
        this.id = id;
    }

    public enum AccountType {
        CURRENT, SAVINGS
    }
}
