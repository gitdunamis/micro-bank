package com.microbank.account.application.query;

import lombok.Value;

@Value
public class GetUserQuery {
    long id;

    public GetUserQuery(long userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User id cannot be less than 1");
        }

        id = userId;
    }
}
