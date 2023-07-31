package com.microbank.transaction.api.controller;

import com.microbank.transaction.api.dto.CreateTransactionRequest;
import com.microbank.transaction.api.dto.BalanceResponse;
import com.microbank.transaction.application.ITransactionService;
import com.microbank.transaction.application.command.CreateTransactionCommand;
import com.microbank.transaction.domain.entity.Balance;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transaction")
public class CreateTransactionController {

    private final ITransactionService transactionService;

    @Inject
    public CreateTransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @POST
    public Response createTransaction(CreateTransactionRequest request) {
        Balance balance = transactionService.createTransaction(new CreateTransactionCommand(
                            request.customerId(), request.amount(), request.type()));

        BalanceResponse response = BalanceResponse.from(balance);

        return Response.ok(balance, MediaType.APPLICATION_JSON_TYPE).build();
    }

}
