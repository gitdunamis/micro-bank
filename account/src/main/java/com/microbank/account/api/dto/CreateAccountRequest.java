package com.microbank.account.api.dto;

import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

import static com.microbank.account.domain.entity.Account.*;

public record CreateAccountRequest (@Min(1) long userId, AccountType type, BigDecimal initialCredit) {
    public CreateAccountRequest {
        if (type == null) {
            type = AccountType.CURRENT;
        }

        if (initialCredit == null) {
            initialCredit = BigDecimal.ZERO;
        }
    }
}
