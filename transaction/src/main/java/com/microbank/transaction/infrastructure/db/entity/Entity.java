package com.microbank.transaction.infrastructure.db.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class Entity {
    long id;
    LocalDateTime createdAt = LocalDateTime.now();
}
