package com.microbank.account.infrastructure.db.repository.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class UserEntity extends Entity {
    String name;

    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

