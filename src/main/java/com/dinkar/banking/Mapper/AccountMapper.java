package com.dinkar.banking.Mapper;

import com.dinkar.banking.DTO.AccountDTO;
import com.dinkar.banking.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account = new Account(accountDTO.getId(), accountDTO.getAccountHolderName(),
				accountDTO.getBalance());
		
		return account;
	}
	
	public static AccountDTO mapToAccountDto(Account account) {
		AccountDTO accountDTO = new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance());
		return accountDTO;
	}
}
