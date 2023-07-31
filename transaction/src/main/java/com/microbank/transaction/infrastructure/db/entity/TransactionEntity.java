package com.microbank.transaction.infrastructure.db.entity;

import com.microbank.transaction.domain.entity.Transaction;
import lombok.Getter;

import java.math.BigDecimal;

import static com.microbank.transaction.domain.entity.Transaction.*;

@Getter
public class TransactionEntity extends Entity{
    long accountId;
    BigDecimal amount;
    TransactionType transactionType;

    public TransactionEntity(long transactionId, long accountId, BigDecimal value, TransactionType type) {
        this.id = transactionId;
        this.accountId = accountId;
        this.amount = value;
        this.transactionType = type;
    }
}
