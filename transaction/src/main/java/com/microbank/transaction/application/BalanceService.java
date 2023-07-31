package com.microbank.transaction.application;

import com.microbank.transaction.application.command.CreateBalanceCommand;
import com.microbank.transaction.application.query.GetBalanceQuery;
import com.microbank.transaction.domain.entity.Balance;
import com.microbank.transaction.domain.repository.IBalanceRepository;
import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;

import java.util.Optional;

public class BalanceService implements IBalanceService {
    private final IBalanceRepository balanceRepository;

    public BalanceService(IBalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public Balance getBalance(GetBalanceQuery query) {
        return balanceRepository.find(new AccountId(query.accountId()))
                .orElseThrow(() -> new RuntimeException("Balance for account id not found"));
    }

    @Override
    public Balance createBalance(CreateBalanceCommand command) {
        var balance = new Balance(new AccountId(command.accountId()), new Amount(command.amount()));
        balanceRepository.create(balance);

        return balance;
    }
}
