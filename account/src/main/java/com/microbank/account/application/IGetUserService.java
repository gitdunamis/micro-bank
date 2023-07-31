package com.microbank.account.application;

import com.microbank.account.application.query.GetUserQuery;
import com.microbank.account.domain.entity.User;

public interface IGetUserService {
    User getUser(GetUserQuery query);
}
