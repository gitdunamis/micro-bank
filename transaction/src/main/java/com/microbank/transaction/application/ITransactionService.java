package com.microbank.transaction.application;

import com.microbank.transaction.application.command.CreateTransactionCommand;
import com.microbank.transaction.domain.entity.Balance;

public interface ITransactionService {
    Balance createTransaction(CreateTransactionCommand command);
}
