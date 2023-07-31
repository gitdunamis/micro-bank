package com.microbank.account.application;

import com.microbank.account.application.exception.ApplicationException;
import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.repository.IUserRepository;
import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.application.query.GetUserQuery;

public class GetUserService implements IGetUserService{
    private final IUserRepository userRepository;

    public GetUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(GetUserQuery query) {
        long userId = query.getId();

        return userRepository.find(new Id(userId)).orElseThrow(() -> new ApplicationException.UserNotFoundException("User with id does not exist."));
    }
}
