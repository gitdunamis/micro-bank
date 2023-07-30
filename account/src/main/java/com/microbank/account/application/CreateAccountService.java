package com.microbank.account.application;

import com.microbank.account.application.command.CreateAccountCommand;
import com.microbank.account.application.query.GetUserQuery;
import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.repository.IAccountRepository;

import static com.microbank.account.domain.entity.Account.*;

public class CreateAccountService implements ICreateAccountService{
    private final IAccountRepository accountRepository;
    private final IGetUserService userService;

    public CreateAccountService(IAccountRepository accountRepository, IGetUserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    @Override
    public void create(CreateAccountCommand command) {
        long userId = command.userId();
        User user = userService.getUser(new GetUserQuery(userId));

        AccountType accountType = command.accountType();
        Account account = Account.from(user.getId().id(), accountType);

        accountRepository.create(account);
    }
}
