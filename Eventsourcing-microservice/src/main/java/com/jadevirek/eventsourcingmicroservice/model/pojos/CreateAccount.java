package com.jadevirek.eventsourcingmicroservice.model.pojos;

import com.jadevirek.eventsourcingmicroservice.model.Account;


public class CreateAccount {

    private Account account;

    public CreateAccount() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
