package com.microbank.transaction.infrastructure.db.repository;

import com.microbank.transaction.domain.entity.Transaction;
import com.microbank.transaction.domain.repository.ITransactionRepository;
import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;
import com.microbank.transaction.domain.valueobject.Id;
import com.microbank.transaction.infrastructure.db.entity.TransactionEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TransactionRepository implements ITransactionRepository {

    private final Map<Long, TransactionEntity> database;

    public TransactionRepository(Map<Long, TransactionEntity> database) {
        Objects.requireNonNull(database);
        this.database = database;
    }

    @Override
    public void create(Transaction transaction) {
        long id = database.keySet().stream().max(Long::compareTo).orElse(0L);

        long nextId = id++;

        database.put(nextId, new TransactionEntity(id, transaction.getAccountId().id(),
                transaction.getAmount().value(), transaction.getType()));
    }

    @Override
    public List<Transaction> findAll() {
        return database.values()
                .stream()
                .map(this::toTransaction)
                .toList();
    }

    private Transaction toTransaction(TransactionEntity entity) {
        return new Transaction(new Id(entity.getId()), new AccountId(entity.getAccountId()),
                entity.getTransactionType(), new Amount(entity.getAmount()));
    }

    @Override
    public List<Transaction> findBy(AccountId accountId) {
        return database.values()
                .stream()
                .filter(entity -> entity.getAccountId() == accountId.id())
                .map(this::toTransaction)
                .toList();
    }
}
