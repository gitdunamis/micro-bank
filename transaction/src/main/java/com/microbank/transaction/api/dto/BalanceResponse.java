package com.microbank.transaction.api.dto;

import com.microbank.transaction.domain.entity.Balance;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public final class BalanceResponse {
    private final long accountId;
    private final BigDecimal balance;

    public BalanceResponse(long accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public static BalanceResponse from(Balance balance) {
        return new BalanceResponse(balance.getAccountId().id(), balance.getValue().value());
    }

    public long accountId() {
        return accountId;
    }

    public BigDecimal balance() {
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BalanceResponse) obj;
        return this.accountId == that.accountId &&
                Objects.equals(this.balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance);
    }

    @Override
    public String toString() {
        return "BalanceResponse[" +
                "accountId=" + accountId + ", " +
                "balance=" + balance + ']';
    }

}
