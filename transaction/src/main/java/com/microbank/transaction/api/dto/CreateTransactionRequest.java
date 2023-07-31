package com.microbank.transaction.api.dto;

import com.microbank.transaction.domain.entity.Transaction;

import java.math.BigDecimal;

public record CreateTransactionRequest(long customerId, BigDecimal amount, Transaction.TransactionType type) {
    public CreateTransactionRequest {
        if (type == null) {
            type = Transaction.TransactionType.CREDIT;
        }
    }
}
