package com.infotech.book.ticket.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.infotech.book.ticket.app.entities.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{
	Ticket findByEmail(String email);
}
