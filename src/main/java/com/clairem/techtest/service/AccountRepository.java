package com.clairem.techtest.service;

import com.clairem.techtest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByAccountId(int accountId);
}
