package com.microbank.transaction.application.command;

import java.math.BigDecimal;

public record CreateBalanceCommand(long accountId, BigDecimal amount) {
}
