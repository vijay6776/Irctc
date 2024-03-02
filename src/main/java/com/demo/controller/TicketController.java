package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Ticket;
import com.demo.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> bookTrainTicket(@RequestBody Ticket ticket){
		String result = ticketService.bookTicket(ticket);
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getATicket(@PathVariable Long id){
		Ticket ticketDetails = ticketService.getTicketDetails(id);
		return new ResponseEntity<Ticket>(ticketDetails,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllBookedTickets(@RequestParam(name="length",required = false) Long length){
		List<Ticket> allTickets = ticketService.getAllTickets(length);
		return new ResponseEntity<List<Ticket>>(allTickets,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Ticket> updateTicketDetails(@RequestBody Ticket ticket,@PathVariable Long id){
		Ticket updatedTicketDetails = ticketService.updateTicketDetails(ticket, id);
		return new ResponseEntity<Ticket>(updatedTicketDetails,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Ticket> updateTicketDetailsByFields(@RequestBody Map<String,Object> fields,@PathVariable Long id){
		Ticket updateTicketDetailsByFields = ticketService.updateTicketDetailsByFields(fields, id);
		return new ResponseEntity<Ticket>(updateTicketDetailsByFields,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cancel/{pnrId}")
	public ResponseEntity<String> cancelTicket(@PathVariable Long pnrId){
		String message="";
		boolean isCancelled = ticketService.cancelTicket(pnrId);
		if(isCancelled) 
		    message="Ticket cancelled successfully";
		else 
			message="Failed to cancel the ticket";
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	

}
