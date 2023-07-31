package com.microbank.account.application;

import com.microbank.account.application.query.GetAccountQuery;
import com.microbank.account.domain.entity.Account;

public interface IGetAccountService {
    Account getAccount(GetAccountQuery query);
}
