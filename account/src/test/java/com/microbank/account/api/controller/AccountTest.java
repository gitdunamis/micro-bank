package com.microbank.account.api.controller;

import com.microbank.account.api.dto.CreateAccountRequest;
import com.microbank.account.api.dto.CreateAccountResponse;
import com.microbank.account.api.dto.Status;
import com.microbank.account.application.CreateAccountService;
import com.microbank.account.application.GetUserService;
import com.microbank.account.application.ICreateAccountService;
import com.microbank.account.application.IGetUserService;
import com.microbank.account.domain.entity.Account.AccountType;
import com.microbank.account.domain.repository.IAccountRepository;
import com.microbank.account.domain.repository.IUserRepository;
import com.microbank.account.infrastructure.db.repository.AccountRepository;
import com.microbank.account.infrastructure.db.repository.UserRepository;
import com.microbank.account.infrastructure.db.entity.AccountEntity;
import com.microbank.account.infrastructure.db.entity.UserEntity;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.microbank.account.application.exception.ApplicationException.*;
import static com.microbank.account.domain.entity.Account.AccountType.CURRENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountTest {

    @DisplayName("Can create Account")
    @Test
    void canCreateAccount() {
        //given
        long userId = 3;
        String userName = "Third User";
        AccountType accountType = CURRENT;
        CreateAccountRequest request = new CreateAccountRequest(userId, null);

        Map<Long, AccountEntity> accountDb = new HashMap<>(1);
        Map<Long, UserEntity> userDb = Collections.singletonMap(userId, new UserEntity(userId, userName));

        IAccountRepository accountRepo = new AccountRepository(accountDb);
        IUserRepository userRepo = new UserRepository(userDb);
        IGetUserService userService = new GetUserService(userRepo);
        ICreateAccountService service = new CreateAccountService(accountRepo, userService);
        CreateAccountController controller = new CreateAccountController(service);

        //when
        ResponseEntity<CreateAccountResponse> response = controller.createAccount(request);

        //then
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        CreateAccountResponse account = response.getBody();

        assertThat(account).isNotNull();
        assertThat(account.status()).isEqualTo(Status.ACCOUNT_CREATED_SUCCESS);
        assertThat(account.message()).isEqualTo("Account Successfully Created");

        assertThat(accountDb.size()).isEqualTo(1);
        assertThat(accountDb).hasEntrySatisfying(1L, new Condition<>(acc -> acc.getAccountType().equals(CURRENT), ""));
    }

    @DisplayName("Creating Account for Non Existing User Results in UserNotFound error")
    @Test
    void cannotCreateAccountForNonExistentUser() {
        //given
        long userId = 3;
        String userName = "Third User";
        AccountType accountType = CURRENT;
        CreateAccountRequest request = new CreateAccountRequest(5, accountType);

        Map<Long, AccountEntity> accountDb = new HashMap<>(1);
        Map<Long, UserEntity> userDb = Collections.singletonMap(userId, new UserEntity(userId, userName));

        IAccountRepository accountRepo = new AccountRepository(accountDb);
        IUserRepository userRepo = new UserRepository(userDb);
        IGetUserService userService = new GetUserService(userRepo);
        ICreateAccountService service = new CreateAccountService(accountRepo, userService);
        CreateAccountController controller = new CreateAccountController(service);


        //then
        assertThatThrownBy(() -> controller.createAccount(request))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User with id does not exist.");

        assertThat(accountDb.size()).isEqualTo(0);
    }

}