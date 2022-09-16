package com.clairem.techtest.service;

import com.clairem.techtest.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {


    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        Account account = new Account(1, 1, 1, 1, LocalDate.now());
        Account account1 = new Account(2, 11, 12, 1234, LocalDate.now());
        Account account2 = new Account(3, 12, 123, 13456, LocalDate.now());
        accountRepository.save(account);
        accountRepository.save(account1);
        accountRepository.save(account2);
    }

    @Test
    public void shouldCreateNewAccount() {
        List<Account> accounts = accountRepository.findByAccountId(1);
        assertThat(accounts).isNotNull();
        assertThat(accounts).hasSize(1);
    }

    @Test
    public void shouldFindAllAccounts() {
        Iterable<Account> accounts = accountRepository.findAll();
        assertThat(accounts).isNotNull();
        assertThat(accounts).hasSize(3);
    }
}