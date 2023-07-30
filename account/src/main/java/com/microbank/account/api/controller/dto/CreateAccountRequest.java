package com.microbank.account.api.controller.dto;

import com.microbank.account.domain.entity.Account;

import static com.microbank.account.domain.entity.Account.*;

public record CreateAccountRequest (@Min() long userId, @NotNull AccountType type){}
