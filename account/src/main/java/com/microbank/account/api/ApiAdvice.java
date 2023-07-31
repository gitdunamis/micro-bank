package com.microbank.account.api;

import com.microbank.account.api.dto.Status;
import com.microbank.account.application.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> handleApplicationException(ApplicationException exception) {

        return switch (exception) {
            case  ApplicationException.AccountNotFoundException e ->
                    ResponseEntity.badRequest().body(new Error(Status.ACCOUNT_DOES_NOT_EXIST, e.getMessage()));
            case ApplicationException.UserNotFoundException e ->
                    ResponseEntity.badRequest().body(new Error(Status.USER_DOES_NOT_EXIST, e.getMessage()));
            case ApplicationException.AccountCreationFailedExecption e ->
                    ResponseEntity.internalServerError().body(new Error(Status.INTERNAL_ERROR, e.getMessage()));
        };
    }



    public record Error(Status status, String message){}
}
