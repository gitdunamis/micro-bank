package com.microbank.account.application.command;

import io.micrometer.common.util.StringUtils;
import lombok.Value;

import java.util.Objects;

@Value
public class CreateUserCommand {
    String name;

    public CreateUserCommand(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name cannot be blank");
        }

        this.name = name;
    }
}
