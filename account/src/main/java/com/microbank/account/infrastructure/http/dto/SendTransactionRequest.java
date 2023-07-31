package com.microbank.account.infrastructure.http.dto;

import java.math.BigDecimal;

public record SendTransactionRequest(long customerId, BigDecimal amount) {}
