package com.microbank.account.application;

import com.microbank.account.domain.entity.Account;

import java.math.BigDecimal;

public interface ITransactionFunder {
    FundStatus fund(Account account, BigDecimal amount);
}
