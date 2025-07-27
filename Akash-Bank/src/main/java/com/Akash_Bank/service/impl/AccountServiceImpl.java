package com.Akash_Bank.service.impl;

// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Akash_Bank.dto.AccountDto;
import com.Akash_Bank.repository.AccountRepository;
import com.Akash_Bank.service.AccountService;

import jakarta.transaction.Transactional;

import com.Akash_Bank.mapper.AccountMapper;
import com.Akash_Bank.entity.Account;

@Service
@Repository
//@Transactional
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountRepository accountRepository;
  // private AccountMapper accountMapper = AccountMapper.INSTANCE;
    public AccountServiceImpl() {
   
  } 
  public AccountServiceImpl(AccountRepository accountRepository) {
    super();
    this.accountRepository = accountRepository;
    }
 

  @Override
    @Transactional
  public AccountDto createAccount(AccountDto accountDto) {

    Account account = AccountMapper.mapToAccount(accountDto);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDto(savedAccount);

  }

  @Override
  public AccountDto getAccount(Long id) {
    Account account = accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found exception"));
    return AccountMapper.mapToAccountDto(account);
  }

  @Override
  public AccountDto deposit(Long id, double amount) {
    Account account = accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found in Bank System"));

    account.setBalance(account.getBalance() + amount);
    Account savedAccount = accountRepository.save(account).flush();
    return AccountMapper.mapToAccountDto(savedAccount);
  }
  // account.setBalance(account.getBalance() + amount);
  // Account savedAccount = accountRepository.save(account);
  // return AccountMapper.mapToAccountDto(savedAccount);
  // }

  @Override
  public AccountDto withdraw(Long id, double amount) {
    Account account = accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found in Bank System"));

    if (account.getBalance() < amount) {
      throw new RuntimeException("Insufficient balance in your account");
    }

    account.setBalance(account.getBalance() - amount);
    Account savedAccount = accountRepository.save(account);
    return AccountMapper.mapToAccountDto(savedAccount);
  }

  @Override
  public List<AccountDto> getAllAccount() {
    return accountRepository.findAll().stream().map((account) -> AccountMapper
        .mapToAccountDto(account)).collect(Collectors.toList());
    // map((account)->AccountMapper.mapToAccount(account));--------> // public
    // static void main(String[] args) {
    // ArrayList<Integer> numbers = new ArrayList<Integer>();
    // numbers.add(5);
    // numbers.add(9);
    // numbers.add(8);
    // numbers.add(1);
    // numbers.forEach( (n) -> { System.out.println(n); } ); /////output 5 9 8 1
    // }

    // .stream to give all account data
  }

  public void deleteAccout(Long id) {
    Account account = accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found in Bank System"));
    accountRepository.delete(account);
  }

}
