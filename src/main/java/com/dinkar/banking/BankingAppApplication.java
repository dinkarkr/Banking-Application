package com.dinkar.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dinkar.banking.repository.AccountRepository;

@SpringBootApplication
public class BankingAppApplication {
	
	@Autowired
	AccountRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	
}
