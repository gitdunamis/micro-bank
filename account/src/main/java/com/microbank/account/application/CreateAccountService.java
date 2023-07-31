package com.microbank.account.application;

import com.microbank.account.application.command.CreateAccountCommand;
import com.microbank.account.application.query.GetUserQuery;
import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.repository.IAccountRepository;
import com.microbank.account.application.exception.ApplicationException.AccountCreationFailedExecption;
import java.math.BigDecimal;

import static com.microbank.account.domain.entity.Account.*;

public class CreateAccountService implements ICreateAccountService{
    private final IAccountRepository accountRepository;
    private final IGetUserService userService;

    private final ITransactionFunder transactionFunder;

    public CreateAccountService(IAccountRepository accountRepository, IGetUserService userService, ITransactionFunder transactionFunder) {
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.transactionFunder = transactionFunder;
    }

    @Override
    public void create(CreateAccountCommand command) {
        long userId = command.userId();
        User user = userService.getUser(new GetUserQuery(userId));

        AccountType accountType = command.accountType();
        Account account = Account.from(user.getId().id(), accountType);

        accountRepository.create(account);

        //fund account
        BigDecimal amount = command.amount();

        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            //fund
            FundStatus status = transactionFunder.fund(account, amount);

            if (status.isNotSuccessful()) {
                //roll back
                accountRepository.delete(account);
                throw new AccountCreationFailedExecption("Error Occurred creating account");
            }
        }

    }
}
