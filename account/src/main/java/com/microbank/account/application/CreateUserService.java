package com.microbank.account.application;

import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.repository.IUserRepository;
import com.microbank.account.application.command.CreateUserCommand;

public class CreateUserService implements ICreateUserService{
    private final IUserRepository userRepository;

    public CreateUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(CreateUserCommand command) {
        String name = command.getName();
        var user = User.newFromName(name);
        userRepository.create(user);
    }
}
