package com.dinkar.banking.service;

import java.util.List;

import com.dinkar.banking.DTO.AccountDTO;

public interface AccountService {
	
	AccountDTO createAccount(AccountDTO accountdto);

	AccountDTO getAccountById(Long id);
	
	AccountDTO deposit(Long id, double ammount);
	
	AccountDTO withdraw(Long id, double ammount);
	
	List<AccountDTO> getAllAccount ();
	
	void deleteAccount(Long id);
}
