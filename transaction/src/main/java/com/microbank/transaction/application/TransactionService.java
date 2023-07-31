package com.microbank.transaction.application;

import com.microbank.transaction.application.command.CreateBalanceCommand;
import com.microbank.transaction.application.command.CreateTransactionCommand;
import com.microbank.transaction.domain.entity.Balance;
import com.microbank.transaction.domain.entity.Transaction;
import com.microbank.transaction.domain.repository.ITransactionRepository;
import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;

public class TransactionService implements ITransactionService {

    private final ITransactionRepository transactionRepository;
    private final IBalanceService balanceService;

    public TransactionService(ITransactionRepository transactionRepository, IBalanceService balanceService) {
        this.transactionRepository = transactionRepository;
        this.balanceService = balanceService;
    }

    @Override
    public Balance createTransaction(CreateTransactionCommand command) {
        Transaction transaction = new Transaction(new AccountId(command.accountId()),
                                    command.type(), new Amount(command.amount()));
        transactionRepository.create(transaction);

        Balance balance = balanceService.createBalance(new CreateBalanceCommand(command.accountId(), command.amount()));

        return balance;
    }
}
