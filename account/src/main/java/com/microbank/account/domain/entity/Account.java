package com.microbank.account.domain.entity;

import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Account {
    Id id;

    @Getter final UserId userId;

    @Getter final AccountType type;

    public enum AccountType {
        CURRENT, SAVINGS
    }
}
