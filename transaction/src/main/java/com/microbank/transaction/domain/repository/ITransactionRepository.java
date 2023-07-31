package com.microbank.transaction.domain.repository;

import com.microbank.transaction.domain.entity.Transaction;
import com.microbank.transaction.domain.valueobject.AccountId;

import java.util.List;

public interface ITransactionRepository {
    void create(Transaction transaction);

    List<Transaction> findAll();

    List<Transaction> findBy(AccountId accountId);
}
