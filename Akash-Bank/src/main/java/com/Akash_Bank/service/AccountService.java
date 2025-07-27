package com.Akash_Bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

// import java.util.Scanner;

import com.Akash_Bank.dto.AccountDto;
// import com.Akash_Bank.entity.Account;
@Service
public interface AccountService {

    AccountDto createAccount(AccountDto account);
    AccountDto getAccount(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto>getAllAccount();
    void deleteAccout(Long id);

}
