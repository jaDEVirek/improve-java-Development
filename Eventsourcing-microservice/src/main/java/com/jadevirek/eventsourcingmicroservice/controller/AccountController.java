package com.jadevirek.eventsourcingmicroservice.controller;

import com.jadevirek.eventsourcingmicroservice.model.Account;
import com.jadevirek.eventsourcingmicroservice.model.enums.AccountEventType;
import com.jadevirek.eventsourcingmicroservice.model.enums.AccountStatus;
import com.jadevirek.eventsourcingmicroservice.model.events.AccountEvent;
import com.jadevirek.eventsourcingmicroservice.model.pojos.CreateAccount;
import com.jadevirek.eventsourcingmicroservice.service.AccountEventService;
import com.jadevirek.eventsourcingmicroservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AccountController {


    private final AccountService accountService;
    private final AccountEventService accountEventService;

    @Autowired
    public AccountController(AccountService accountService,
            AccountEventService accountEventService) {
        this.accountService = accountService;
        this.accountEventService = accountEventService;
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody CreateAccount createAccount) {
        accountEventService.saveAccountEvent(new AccountEvent(AccountEventType.PENDING, createAccount.getAccount()
                .getAccountNumber()));
        return accountService.createAccount(createAccount);
    }

    @PostMapping("/accounts/{id}/activate")
    public Account activateAccount(@PathVariable Long id) {
        Account account = accountService.getAccount(id);

        if (account.getStatus()
                .equals(AccountStatus.PENDING)) {
            account.setStatus(AccountStatus.ACTIVE);
            accountEventService.saveAccountEvent(new AccountEvent(AccountEventType.ACTIVE, account.getAccountNumber()));

        } else {
            throw new IllegalStateException("The account has wrong status!");
        }
        return account;
    }
}
