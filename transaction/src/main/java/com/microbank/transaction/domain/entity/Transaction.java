package com.microbank.transaction.domain.entity;

import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Id;

import java.time.LocalDateTime;

public class Transaction {
    Id id;
    AccountId accountId;
    Amount amount;
    TransactionType type;
    LocalDateTime createdAt = LocalDateTime.now();
}
