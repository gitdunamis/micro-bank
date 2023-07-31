package com.microbank.account.domain.valueobject;

public record Id(long id) {

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Id i && i.id == id;
    }
}
