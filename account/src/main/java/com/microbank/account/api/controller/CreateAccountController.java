package com.microbank.account.api.controller;

import com.microbank.account.api.dto.CreateAccountRequest;
import com.microbank.account.api.dto.CreateAccountResponse;
import com.microbank.account.application.ICreateAccountService;
import com.microbank.account.application.command.CreateAccountCommand;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/account")
public class CreateAccountController {
    private final ICreateAccountService createAccountService;

    public CreateAccountController(ICreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    @PostMapping("/")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody @Valid CreateAccountRequest request) {

        createAccountService.create(new CreateAccountCommand(request.userId(), request.type()));

        return ResponseEntity.created( URI.create("")).body(CreateAccountResponse.success());
    }

}
