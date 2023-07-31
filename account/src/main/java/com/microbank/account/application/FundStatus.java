package com.microbank.account.application;

public enum FundStatus {
    SUCCESS,
    FAILED;

    public boolean isNotSuccessful() {
        return this != SUCCESS;
    }
}
