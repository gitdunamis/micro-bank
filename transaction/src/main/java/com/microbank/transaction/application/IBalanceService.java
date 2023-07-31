package com.microbank.transaction.application;

import com.microbank.transaction.application.command.CreateBalanceCommand;
import com.microbank.transaction.application.query.GetBalanceQuery;
import com.microbank.transaction.domain.entity.Balance;

public interface IBalanceService {
    Balance getBalance(GetBalanceQuery query);

    Balance createBalance(CreateBalanceCommand command);
}
