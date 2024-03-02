package com.demo.service;

import java.util.List;
import java.util.Map;


import com.demo.entity.Ticket;

public interface TicketService {
	
	public String bookTicket(Ticket ticket);
	
   public Ticket getTicketDetails(Long pnr);
   
   public List<Ticket> getAllTickets(Long length);
   
   public Ticket updateTicketDetails(Ticket t,Long pnrNumber);
   
   public Ticket updateTicketDetailsByFields(Map<String,Object> fields,Long id);
   
   public boolean cancelTicket(Long pnrNumber);

  
}
