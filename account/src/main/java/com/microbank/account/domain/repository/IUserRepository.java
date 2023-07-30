package com.microbank.account.domain.repository;

import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.valueobject.Id;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> find (Id id);

    void create(User user);
}
