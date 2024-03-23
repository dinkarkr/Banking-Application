package com.dinkar.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dinkar.banking.DTO.AccountDTO;
import com.dinkar.banking.Mapper.AccountMapper;
import com.dinkar.banking.entity.Account;
import com.dinkar.banking.repository.AccountRepository;
import com.dinkar.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account  = AccountMapper.mapToAccount(accountDTO);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDTO getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDTO deposit(Long id, double ammount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		double total = account.getBalance() + ammount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);

	}

	@Override
	public AccountDTO withdraw(Long id, double ammount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		if(account.getBalance() < ammount) {
			throw new RuntimeException("Insufficient Amount"); 
		}

		double total = account.getBalance() - ammount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
		.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		accountRepository.deleteById(id);
		
	}

}
