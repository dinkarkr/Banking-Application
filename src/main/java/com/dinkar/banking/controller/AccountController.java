package com.dinkar.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinkar.banking.DTO.AccountDTO;
import com.dinkar.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	//Create Account API
	@PostMapping
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDto){
		return new ResponseEntity<AccountDTO>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	//Get Acount API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountBtId(@PathVariable Long id){
		AccountDTO accountDTO = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDTO);
	}


	//Deposit Amount api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> depositAmmount(@PathVariable Long id, 
			@RequestBody Map<String, Double> request){
		AccountDTO accountDto = accountService.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}

	//Withdraw Amount api
	@PutMapping( "/{id}/withdraw")
	public ResponseEntity<AccountDTO> withDrawAmmount(@PathVariable Long id, 
			@RequestBody Map<String, Double> request){
		AccountDTO accountDto = accountService.withdraw(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}

	//Get Acount API
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccount(){
		List<AccountDTO> accounts = accountService.getAllAccount();
		return ResponseEntity.ok(accounts);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted Successfully!");
	}
}
