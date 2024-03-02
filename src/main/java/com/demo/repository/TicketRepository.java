package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
