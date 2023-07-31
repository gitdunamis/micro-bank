package com.microbank.transaction.domain.repository;

import com.microbank.transaction.domain.entity.Balance;
import com.microbank.transaction.domain.valueobject.AccountId;

import java.util.Optional;

public interface IBalanceRepository {
    void create(Balance balance);
    Optional<Balance> find(AccountId accountId);
}
