package com.microbank.transaction.domain.entity;

import com.microbank.transaction.domain.valueobject.AccountId;
import com.microbank.transaction.domain.valueobject.Amount;
import com.microbank.transaction.domain.valueobject.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Balance {
    Id id;
    AccountId accountId;
    Amount value;
}
