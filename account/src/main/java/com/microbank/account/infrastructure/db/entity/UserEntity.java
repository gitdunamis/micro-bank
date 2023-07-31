package com.microbank.account.infrastructure.db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends Entity {
    String name;

    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

