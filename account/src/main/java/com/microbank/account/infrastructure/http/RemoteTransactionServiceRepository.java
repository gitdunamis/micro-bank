package com.microbank.account.infrastructure.http;

import com.microbank.account.application.FundStatus;
import com.microbank.account.application.ITransactionFunder;
import com.microbank.account.domain.entity.Account;
import com.microbank.account.infrastructure.http.dto.SendTransactionRequest;
import com.microbank.account.infrastructure.http.dto.SendTransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.logging.ErrorManager;

public class RemoteTransactionServiceRepository implements ITransactionFunder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteTransactionServiceRepository.class);
    private final String baseUrl;
    private final RestTemplate restTemplate;

    public RemoteTransactionServiceRepository(String baseUrl,
                                              RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public FundStatus fund(Account account, BigDecimal amount) {
        try {
            String url = baseUrl + "/transaction";
            SendTransactionRequest request = new SendTransactionRequest(account.getId().id(), amount);

            SendTransactionResponse sendTransactionResponse = restTemplate.postForEntity(url, request, SendTransactionResponse.class).getBody();

            LOGGER.info("Response from remote: {}", sendTransactionResponse);

            return FundStatus.SUCCESS;

        } catch (Exception e) { // remote server could have made the impact but failed to response...handle
            LOGGER.error("Error occurred sending fund", e);
            return FundStatus.FAILED;
        }
    }
}
