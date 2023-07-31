package com.microbank.account.infrastructure.http.dto;

import java.math.BigDecimal;

public record SendTransactionResponse(long accountId, BigDecimal balance) {}
