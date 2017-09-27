package com.infotech.book.ticket.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.infotech.book.ticket.app.dao.TicketBookingDao;
import com.infotech.book.ticket.app.entities.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketBookingServiceTest {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@MockBean
	private TicketBookingDao ticketBookingDao;
	
	@Test
	public void testCreateTicket(){

		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(new Date());
		ticket.setEmail("martin.s2017@gmail.com");
		
	    Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);
	    
	    assertThat(ticketBookingService.createTicket(ticket)).isEqualTo(ticket);
	
	}
	
	
	@Test
	public void testGetTicketById(){
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(new Date());
		ticket.setEmail("martin.s2017@gmail.com");
		
	    Mockito.when(ticketBookingDao.findOne(1)).thenReturn(ticket);
	    assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
	}
	
	@Test
	public void testGetAllBookedTickets(){
		Ticket ticket1 = new Ticket();
		ticket1.setPassengerName("Martin Bingel");
		ticket1.setSourceStation("Kolkata");
		ticket1.setDestStation("Delhi");
		ticket1.setBookingDate(new Date());
		ticket1.setEmail("martin.s2017@gmail.com");
		
		Ticket ticket2 = new Ticket();
		ticket2.setPassengerName("Sean Murphy");
		ticket2.setSourceStation("Kolkata");
		ticket2.setDestStation("Mumbai");
		ticket2.setBookingDate(new Date());
		ticket2.setEmail("sean.s2017@gmail.com");
		
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		
		Mockito.when(ticketBookingDao.findAll()).thenReturn(ticketList);
		
		assertThat(ticketBookingService.getAllBookedTickets()).isEqualTo(ticketList);
	}
	
	
	@Test
	public void testDeleteTicket(){
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(new Date());
		ticket.setEmail("martin.s2017@gmail.com");
		
	    Mockito.when(ticketBookingDao.findOne(1)).thenReturn(ticket);
	    Mockito.when(ticketBookingDao.exists(ticket.getTicketId())).thenReturn(false);
	   assertFalse(ticketBookingDao.exists(ticket.getTicketId()));
	}
	
	
	@Test
	public void testUpdateTicket(){
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(new Date());
		ticket.setEmail("martin.s2017@gmail.com");
		
		Mockito.when(ticketBookingDao.findOne(1)).thenReturn(ticket);
		
		ticket.setEmail("martin.s2000@gmail.com");
		Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);
		
		assertThat(ticketBookingService.updateTicket(1, "martin.s2017@gmail.com")).isEqualTo(ticket);
		
	}
	
	@Test
	public void testGetTicketByEmail(){
		
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(new Date());
		ticket.setEmail("martin.s2017@gmail.com");
		
	    Mockito.when(ticketBookingDao.findByEmail("martin.s2017@gmail.com")).thenReturn(ticket);
	    
	    assertThat(ticketBookingService.getTicketByEmail("martin.s2017@gmail.com")).isEqualTo(ticket);
	}
	
}
