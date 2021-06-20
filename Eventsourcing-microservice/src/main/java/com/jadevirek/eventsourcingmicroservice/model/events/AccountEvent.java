package com.jadevirek.eventsourcingmicroservice.model.events;


import com.jadevirek.eventsourcingmicroservice.model.enums.AccountEventType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AccountEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Long timestamp;

    private AccountEventType eventType;

    public AccountEvent(AccountEventType eventType) {
        this.timestamp = new Date().getTime();
        this.eventType = eventType;
    }

    public AccountEventType getEventType() {
        return eventType;
    }

    public void setEventType(AccountEventType eventType) {
        this.eventType = eventType;
    }
}
