package com.microbank.account.domain.repository;

import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.valueobject.Id;

import java.util.Optional;

public interface IAccountRepository {
    Optional<Account> find(Id id);

    void create(Account account);

    void delete(Account account);
}
