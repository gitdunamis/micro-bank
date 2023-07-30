package com.microbank.account.api.controller;

import com.microbank.account.api.controller.dto.CreateAccountRequest;
import com.microbank.account.api.controller.dto.CreateAccountResponse;
import com.microbank.account.application.ICreateAccountService;
import com.microbank.account.application.command.CreateAccountCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class CreateAccountController {
    private final ICreateAccountService createAccountService;

    public CreateAccountController(ICreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    public ResponseEntity<CreateAccountResponse> createAccount(CreateAccountRequest request) {

        createAccountService.create(new CreateAccountCommand(request.userId(), request.type()));


        return ResponseEntity.created(new URI()).body(new CreateAccountResponse());
    }
}
