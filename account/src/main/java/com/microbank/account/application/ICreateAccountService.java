package com.microbank.account.application;

import com.microbank.account.application.command.CreateAccountCommand;

public interface ICreateAccountService {

    void create(CreateAccountCommand command);
}
