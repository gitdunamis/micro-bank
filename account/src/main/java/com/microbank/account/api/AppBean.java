package com.microbank.account.api;

import com.microbank.account.application.*;
import com.microbank.account.domain.entity.Account;
import com.microbank.account.domain.repository.IAccountRepository;
import com.microbank.account.domain.repository.IUserRepository;
import com.microbank.account.infrastructure.db.repository.AccountRepository;
import com.microbank.account.infrastructure.db.repository.UserRepository;
import com.microbank.account.infrastructure.db.entity.AccountEntity;
import com.microbank.account.infrastructure.db.entity.UserEntity;
import com.microbank.account.infrastructure.http.RemoteTransactionServiceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppBean {

    @Value("${transactions.base.url}")
    String transactionUrl;

    @Bean
    public IAccountRepository accountRepository() {
        Map<Long, AccountEntity> map = new HashMap<>() {{
            put(1L, new AccountEntity(1L, Account.AccountType.SAVINGS, 1L));
        }};

        return new AccountRepository(map);
    }

    @Bean
    public IUserRepository userRepository() {
        Map<Long, UserEntity> db = new HashMap<>() {{
            put(1L, new UserEntity(1L, "First User"));
        }};

        return new UserRepository(db);
    }

    @Bean
    public IGetAccountService getAccountService(IAccountRepository accountRepository) {
        return new GetAccountService(accountRepository);
    }

    @Bean
    public IGetUserService getUserService(IUserRepository userRepository) {
        return new GetUserService(userRepository);
    }

    @Bean
    public ITransactionFunder transactionFunder() {
        return new RemoteTransactionServiceRepository(transactionUrl, new RestTemplate());
    }

    @Bean
    public ICreateAccountService createAccountService(IAccountRepository accountRepository, IGetUserService getUserService, ITransactionFunder transactionFunder) {
        return new CreateAccountService(accountRepository, getUserService, transactionFunder);
    }

    @Bean
    public ICreateUserService createUserService(IUserRepository userRepository) {
        return new CreateUserService(userRepository);
    }

}
