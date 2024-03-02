package com.demo.exceptionHandling;

public class GetAllTicketsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GetAllTicketsException() {
		
	}
public GetAllTicketsException(String msg) {
		super(msg);
	}

}
