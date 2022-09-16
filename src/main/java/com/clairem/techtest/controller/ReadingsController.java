package com.clairem.techtest.controller;


import com.clairem.techtest.model.Account;
import com.clairem.techtest.service.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/smart/reads")
public class ReadingsController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(value = "/{accountId}", produces = "application/json")
    public ResponseEntity<List<Account>> findByAccountId(@PathVariable("accountId") final int accountId) throws Exception {
        try {
            List<Account> account = accountRepository.findByAccountId(accountId);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/accounts")
    public List<Account> getAll() {
        final List<Account> account = new ArrayList<>();
        accountRepository.findAll().forEach(account::add);
        return account;
    }

    //Testing Post to add data for In-Memory Connection
    @PostMapping (value = "/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            Account _account = accountRepository.save(new Account(account.getAccountId(), account.getId(), account.getMeterId(), account.getReading(), LocalDate.now()));
            return new ResponseEntity<>(_account, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Testing Put for adding data or changing data for In-Memory connection

    @PutMapping("/account/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable("accountId") long id, @RequestBody Account account) {
        Optional<Account> AccountData = accountRepository.findById(id);
        if (AccountData.isPresent()) {
            Account account1 = AccountData.get();
            account1.setAccountId(account.getAccountId());
            account1.setId(1);
            account1.setMeterId(1234);
            account1.setReading(1029);
            account1.setDate(LocalDate.now());
            return new ResponseEntity<>(accountRepository.save(account1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
