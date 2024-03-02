package com.demo.exceptionHandling;

public class PnrNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PnrNotFoundException() {
		
	}
	public PnrNotFoundException(String msg) {
		super(msg);
		
	}
	
	

}
