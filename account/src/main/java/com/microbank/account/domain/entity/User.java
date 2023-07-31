package com.microbank.account.domain.entity;

import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.domain.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    Id id;
    @Getter Name name;

    private User(Name name) {
        this.name = name;
    }


    public static User newFromName(String name) {
        return new User(new Name(name));
    }
}
