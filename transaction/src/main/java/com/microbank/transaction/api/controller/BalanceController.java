package com.microbank.transaction.api.controller;

import com.microbank.transaction.api.dto.BalanceResponse;
import com.microbank.transaction.application.IBalanceService;
import com.microbank.transaction.application.query.GetBalanceQuery;
import com.microbank.transaction.domain.entity.Balance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/balance")
public class BalanceController {
    private final IBalanceService balanceService;

    @Inject
    public BalanceController(IBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GET
    @Path("{id}")
    public Response getBalance(@PathParam("id") long id) {
        Balance balance = balanceService.getBalance(new GetBalanceQuery(id));

        BalanceResponse response = BalanceResponse.from(balance);

        return Response.ok(response, MediaType.APPLICATION_JSON_TYPE).build();
    }
}
