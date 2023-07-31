package com.microbank.transaction.domain.entity;

import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;
import com.microbank.transaction.domain.valueobject.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Transaction {
    Id id;
    AccountId accountId;
    Amount amount;
    TransactionType type;

    public Transaction(Id id, AccountId accountId, TransactionType type, Amount amount) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
    }

    public enum TransactionType {
        CREDIT, DEBIT
    }
}
