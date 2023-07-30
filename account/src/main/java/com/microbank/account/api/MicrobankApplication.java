package com.microbank.account.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.microbank")
public class MicrobankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrobankApplication.class);
    }

}
