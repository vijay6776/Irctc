package com.demo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;


import com.demo.entity.Ticket;
import com.demo.exceptionHandling.GetAllTicketsException;
import com.demo.exceptionHandling.PnrNotFoundException;
import com.demo.repository.TicketRepository;
@Service
public class TicketServiceImpl implements TicketService {
	
	
	private TicketRepository ticketRepository;
    
	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public String bookTicket(Ticket ticket) {
		Ticket ticketDetails = ticketRepository.save(ticket);
		if(ticketDetails.getPnrNumber()!=null) {
			return "Train Ticket Booked Successfully";
		}
		return "Failed To Book The Ticket";
	}

	@Override
	public Ticket getTicketDetails(Long pnr) {
		Ticket ticket = ticketRepository.findById(pnr).orElseThrow(()->new PnrNotFoundException("No PNR Found with this Id"));
	    return ticket;
	}

	@Override
	public List<Ticket> getAllTickets(Long length) {
		List<Ticket> allTickets = ticketRepository.findAll();
		if(allTickets.isEmpty()) {
			throw new GetAllTicketsException("Failed to get the tickets");
		}
		else {
			
		if(length==null)
		return ticketRepository.findAll()  ;
		else 
			return ticketRepository.findAll().stream().limit(length).collect(Collectors.toList());
		}
	}

	@Override
	public Ticket updateTicketDetails(Ticket t, Long pnrNumber) {
		 Ticket ticket = ticketRepository.findById(pnrNumber).get();
		 ticket.setDate(t.getDate());
		 ticket.setDestinationStation(t.getDestinationStation());
		 ticket.setPassengerName(t.getPassengerName());
		 ticket.setSourceStation(t.getSourceStation());
		 ticket.setTicketPrice(t.getTicketPrice());
		 ticket.setTrainName(t.getTrainName());
		 ticket.setTrainNumber(t.getTrainNumber());
		 return ticketRepository.save(ticket);
	}
	
	@Override
	public Ticket updateTicketDetailsByFields(Map<String,Object> fields,Long id) {
		 Optional<Ticket> ticketDetails = ticketRepository.findById(id);
		 if(ticketDetails.isPresent()) {
			 fields.forEach((key,value)->{
				 Field field = ReflectionUtils.findRequiredField(Ticket.class, key);
				 field.setAccessible(true);
				 ReflectionUtils.setField(field, ticketDetails.get(), value);
			 });
			 return ticketRepository.save(ticketDetails.get());
		 }
		 return null;
	}

	@Override
	public boolean cancelTicket(Long pnrNumber) {
		Ticket ticket = ticketRepository.findById(pnrNumber).orElseThrow(()->new PnrNotFoundException("No PNR Found With This Id"));
		if(ticket!=null) {
			ticketRepository.deleteById(pnrNumber);
			return true;
		}
		return false;
	}
	
	

	

	
	
	
	
	

}
