package com.jadevirek.eventsourcingmicroservice.service;

import com.jadevirek.eventsourcingmicroservice.model.events.AccountEvent;
import com.jadevirek.eventsourcingmicroservice.repository.AccountEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEventService {

    private final AccountEventRepository accountEventRepository;

    @Autowired
    public AccountEventService(
            AccountEventRepository accountEventRepository) {
        this.accountEventRepository = accountEventRepository;
    }

    public AccountEvent saveAccountEvent(AccountEvent accountEvent) {
        return this.accountEventRepository.save(accountEvent);
    }
}
