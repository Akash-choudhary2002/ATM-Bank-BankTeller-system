package com.Akash_Bank.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Akash_Bank.service.AccountService;
import com.Akash_Bank.dto.AccountDto;

import java.util.List;
import java.util.Map;
// import org.springframework.web.bind.annotation.RequestParam;
@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    
    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;   


    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        System.out.println(accountDto);
        
        return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
  
   }
   
   @GetMapping("/{id}")
  public ResponseEntity<AccountDto>getAccountById(@PathVariable Long id){
   AccountDto accountDto = accountService.getAccount(id);
   return  ResponseEntity.ok(accountDto);
    // return new ResponseEntity<AccountDto>(accountService.getAccount(id), HttpStatus.OK);

  }
  @PutMapping("/{id}/deposit")
  public ResponseEntity<AccountDto>deposit(@PathVariable Long id,
  @RequestBody Map<String,Double> request){
    
    Double amount= request.get("amount");
    AccountDto accountDto = accountService.deposit(id, amount);
    return ResponseEntity.ok(accountDto);
    // return new ResponseEntity<AccountDto>(accountService.deposit(id,amount.get("amount")), HttpStatus.OK);
  }
   @PutMapping("/{id}/withdraw")
  //  public String putMethodName(@PathVariable String id, @RequestBody String entity) {
  //      //TODO: process PUT request
       
  //      return entity;
  //  }
   public ResponseEntity<AccountDto>withdraw(@PathVariable Long id, @RequestBody Map<String, Double>request){
     
    Double amount = request.get("amount");
    AccountDto accountDto = accountService.withdraw(id,amount);
  

    return ResponseEntity.ok(accountDto);
     // return new ResponseEntity<AccountDto>
    //  (accountService.withdroaw(id,amount.get("amount")), HttpStatus.OK);
  
   }
  
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
      List<AccountDto>accountDto = accountService.getAllAccount();
      return ResponseEntity.ok(accountDto);
    } 
   @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccount(@PathVariable Long id){
      accountService.deleteAccout(id);
      return ResponseEntity.ok("Account deleted successfully");
    
    
    
    }

}
                       