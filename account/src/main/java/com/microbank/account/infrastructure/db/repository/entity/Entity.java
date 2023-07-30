package com.microbank.account.infrastructure.db.repository.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Entity {
    long id;
    LocalDateTime createdAt = LocalDateTime.now();
}
