package com.microbank.transaction.api.config;

import com.microbank.transaction.application.BalanceService;
import com.microbank.transaction.application.IBalanceService;
import com.microbank.transaction.application.ITransactionService;
import com.microbank.transaction.application.TransactionService;
import com.microbank.transaction.domain.repository.IBalanceRepository;
import com.microbank.transaction.domain.repository.ITransactionRepository;
import com.microbank.transaction.infrastructure.db.entity.BalanceEntity;
import com.microbank.transaction.infrastructure.db.entity.TransactionEntity;
import com.microbank.transaction.infrastructure.db.repository.BalanceRepository;
import com.microbank.transaction.infrastructure.db.repository.TransactionRepository;
import jakarta.enterprise.inject.Produces;

import java.util.HashMap;
import java.util.Map;

public class CDIBeans {

    @Produces
    public IBalanceService balanceService() {
        Map<Long, BalanceEntity> database = new HashMap<>();
        IBalanceRepository repository = new BalanceRepository(database);
        return new BalanceService(repository);
    }

    @Produces
    public ITransactionService transactionService(IBalanceService balanceService) {
        Map<Long, TransactionEntity> database = new HashMap<>();
        ITransactionRepository repository = new TransactionRepository(database);
        return new TransactionService(repository, balanceService);
    }
}
