package com.jadevirek.eventsourcingmicroservice.repository;

import com.jadevirek.eventsourcingmicroservice.model.events.AccountEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEventRepository extends JpaRepository<AccountEvent, Long> {
}
