package com.demo.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Ticket_Details")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pnrNumber;
	private String passengerName;
	private Long trainNumber;
	private String trainName;
	private String sourceStation;
	private String destinationStation;
	private Double ticketPrice;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate Date;
	
	

}
