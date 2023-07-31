package com.microbank.account.domain.valueobject;

public record Name(String name) {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Name n && n.name == name;
    }
}
