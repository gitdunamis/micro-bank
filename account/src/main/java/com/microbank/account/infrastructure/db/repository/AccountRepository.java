package com.microbank.account.infrastructure.db.repository;

import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.repository.IAccountRepository;
import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.domain.valueobject.UserId;
import com.microbank.account.infrastructure.db.repository.entity.AccountEntity;

import java.util.Map;
import java.util.Optional;

public class AccountRepository implements IAccountRepository {

    private final Map<Long, AccountEntity> database;

    public AccountRepository(Map<Long, AccountEntity> database) {
        this.database = database;
    }

    @Override
    public Optional<Account> find(Id id) {
        return database.values()
                .stream()
                .filter(entity -> entity.getId() == id.id())
                .map(entity -> new Account(id, new UserId(entity.getUserId()), entity.getAccountType()))
                .findFirst();
    }

    @Override
    public void create(Account account) {
        long id = database.keySet().stream().max(Long::compareTo).orElse(0L);

        long entityId = ++id;
        AccountEntity entity = new AccountEntity(account.getUserId().id(), account.getType(), entityId);
        database.put(entityId, entity);
    }
}
