package com.microbank.account.application;

import com.microbank.account.application.command.CreateUserCommand;

public interface ICreateUserService {

    void create(CreateUserCommand command);
}
