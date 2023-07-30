package com.microbank.account.domain.valueobject;

public record UserId(long id){
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UserId i && i.id == id;
    }
}
