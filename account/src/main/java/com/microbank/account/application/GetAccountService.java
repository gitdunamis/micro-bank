package com.microbank.account.application;

import com.microbank.account.application.query.GetAccountQuery;
import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.repository.IAccountRepository;
import com.microbank.account.domain.valueobject.Id;

import static com.microbank.account.application.exception.NotFoundException.*;

public class GetAccountService implements IGetAccountService {
    private final IAccountRepository accountRepository;

    public GetAccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(GetAccountQuery query) {
        long id = query.accountId();

        return accountRepository.find(new Id(id)).orElseThrow(() -> new AccountNotFoundException("Account with id does not exist"));
    }
}
