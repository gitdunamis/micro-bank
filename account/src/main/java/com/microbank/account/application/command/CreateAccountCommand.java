package com.microbank.account.application.command;

import java.math.BigDecimal;
import java.util.Objects;

import static com.microbank.account.domain.entity.Account.*;

public record CreateAccountCommand(long userId, AccountType accountType, BigDecimal amount) {
    public CreateAccountCommand {
        if (userId < 0) {
            throw new IllegalArgumentException("User id cannot be less than 0");
        }

        Objects.requireNonNull(accountType, "Account Type must be one of CURRENT,SAVINGS");

        if (amount ==  null) {
            amount = BigDecimal.ZERO;
        }

    }
}
