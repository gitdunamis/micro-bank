package com.microbank.transaction.application.command;

import java.math.BigDecimal;

import static com.microbank.transaction.domain.entity.Transaction.*;

public record CreateTransactionCommand(long accountId, BigDecimal amount, TransactionType type){

    public CreateTransactionCommand {
        if (accountId < 1) {
            throw new IllegalArgumentException("Amount cannot be less than 1");
        }

        if (type == null) {
            type = TransactionType.CREDIT;
        }
    }
}
