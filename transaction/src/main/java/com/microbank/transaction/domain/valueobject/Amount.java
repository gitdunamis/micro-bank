package com.microbank.transaction.domain.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

public record Amount(BigDecimal value) {
    public Amount {
        if (value == null) {
            value = BigDecimal.ZERO;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Amount a && Objects.equals(a.value, value);
    }
}
