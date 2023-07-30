package com.microbank.account.api.controller;

import com.microbank.account.api.dto.GetAccountResponse;
import com.microbank.account.application.IGetAccountService;
import com.microbank.account.application.query.GetAccountQuery;
import com.microbank.account.domain.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class GetAccountController {
    private final IGetAccountService getAccountService;

    public GetAccountController(IGetAccountService getAccountService) {
        this.getAccountService = getAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable("id") long id) {
        Account account = getAccountService.getAccount(new GetAccountQuery(id));

        GetAccountResponse response = GetAccountResponse.from(account);

        return ResponseEntity.ok(response);
    }

}
