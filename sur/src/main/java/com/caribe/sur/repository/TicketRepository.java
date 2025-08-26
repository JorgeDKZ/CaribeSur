package com.caribe.sur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caribe.sur.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
