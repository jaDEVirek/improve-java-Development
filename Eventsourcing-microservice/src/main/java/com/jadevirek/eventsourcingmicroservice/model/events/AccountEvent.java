package com.jadevirek.eventsourcingmicroservice.model.events;


import com.jadevirek.eventsourcingmicroservice.model.enums.AccountEventType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private String accountNumber;

    private AccountEventType eventType = AccountEventType.PENDING;

    public AccountEvent(AccountEventType eventType, String accountNumber) {
        this.eventType = eventType;
        this.accountNumber=accountNumber;
    }

    public AccountEvent() {
        this.timestamp = new Date();
    }

    public AccountEventType getEventType() {
        return eventType;
    }

    public void setEventType(AccountEventType eventType) {
        this.eventType = eventType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
