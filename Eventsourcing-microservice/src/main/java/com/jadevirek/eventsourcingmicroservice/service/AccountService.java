package com.jadevirek.eventsourcingmicroservice.service;

import com.jadevirek.eventsourcingmicroservice.model.Account;
import com.jadevirek.eventsourcingmicroservice.model.pojos.CreateAccount;
import com.jadevirek.eventsourcingmicroservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Long id) {
        return accountRepository.getOne(id);
    }

    public Account createAccount(CreateAccount createAccount) {
        return accountRepository.save(createAccount.getAccount());
    }
}
