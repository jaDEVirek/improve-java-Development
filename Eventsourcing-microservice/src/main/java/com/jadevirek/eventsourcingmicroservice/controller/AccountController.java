package com.jadevirek.eventsourcingmicroservice.controller;

import com.jadevirek.eventsourcingmicroservice.model.Account;
import com.jadevirek.eventsourcingmicroservice.model.enums.AccountEventType;
import com.jadevirek.eventsourcingmicroservice.model.events.AccountEvent;
import com.jadevirek.eventsourcingmicroservice.model.pojos.CreateAccount;
import com.jadevirek.eventsourcingmicroservice.repository.AccountEventRepository;
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

    @GetMapping("accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("accounts/")
    public Account createAccount(CreateAccount createAccount) {
        accountEventService.saveAccountEvent(new AccountEvent(AccountEventType.PENDING));
        return accountService.createAccount(createAccount);
    }
}
