package com.microbank.account.api;

import com.microbank.account.api.dto.Status;
import com.microbank.account.application.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException exception) {
        Error resp = switch (exception) {
            case  ApplicationException.AccountNotFoundException e -> new Error(Status.ACCOUNT_DOES_NOT_EXIST, e.getMessage());
            case ApplicationException.UserNotFoundException e -> new Error(Status.USER_DOES_NOT_EXIST, e.getMessage());
        };

        return ResponseEntity.badRequest().body(resp);
    }

    record Error(Status status, String message){}
}
