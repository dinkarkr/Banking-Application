package com.dinkar.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.dinkar.banking.repository.AccountRepository;

@SpringBootApplication
public class BankingAppApplication {
	
	@Autowired
	AccountRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

	@EventListener()
	public void findById(ContextRefreshedEvent contextRefreshedEvent) {
		System.out.println(repository.findAll()); 
	}
	
}
