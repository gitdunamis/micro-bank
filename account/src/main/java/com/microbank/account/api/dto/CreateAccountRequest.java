package com.microbank.account.api.dto;

import com.microbank.account.domain.entity.Account;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import static com.microbank.account.domain.entity.Account.*;

public record CreateAccountRequest (@Min(1) long userId, AccountType type) {
    public CreateAccountRequest {
        if (type == null) {
            type = AccountType.CURRENT;
        }
    }
}
