package com.microbank.transaction.infrastructure.db.repository;

import com.microbank.transaction.domain.entity.Balance;
import com.microbank.transaction.domain.repository.IBalanceRepository;
import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;
import com.microbank.transaction.domain.valueobject.Id;
import com.microbank.transaction.infrastructure.db.entity.BalanceEntity;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class BalanceRepository extends Repository<BalanceEntity> implements IBalanceRepository {

    public BalanceRepository(Map<Long, BalanceEntity> database) {
        super(database);
    }

    @Override
    public void create(Balance balance) {
        long id = getLastId() + 1;
        BalanceEntity entity = new BalanceEntity(id, balance.getAccountId().id(), balance.getValue().value());

        database.put(id, entity);
    }

    @Override
    public Optional<Balance> find(AccountId accountId) {
        Predicate<BalanceEntity> predicate = balance -> balance.getAccountId() == balance.getAccountId();
        Function<BalanceEntity, Balance> mapper = entity -> new Balance(new Id(entity.getId()),
                                    new AccountId(entity.getAccountId()), new Amount(entity.getBalance()));

        return findMap(predicate, mapper);
    }
}
