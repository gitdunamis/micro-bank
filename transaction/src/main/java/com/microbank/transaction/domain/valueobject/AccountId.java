package com.microbank.transaction.domain.valueobject;

public record AccountId(long id){
    @Override
    public boolean equals(Object obj) {
        return obj instanceof AccountId i && i.id == id;
    }
}
