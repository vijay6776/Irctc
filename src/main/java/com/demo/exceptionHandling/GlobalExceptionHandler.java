package com.demo.exceptionHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    
	 @ExceptionHandler(value = PnrNotFoundException.class)
	public ResponseEntity<ExceptionBean> handleTicketException(PnrNotFoundException te){
		 String message = te.getMessage();
		 ExceptionBean eb=new ExceptionBean();
		 eb.setErrorCode("601");
		 eb.setErrorMsg(message);
		 return new ResponseEntity<ExceptionBean> (eb,HttpStatus.BAD_REQUEST);
		 
	 }
	 
	 @ExceptionHandler(value = GetAllTicketsException.class)
		public ResponseEntity<ExceptionBean> GetAllTicketsException(GetAllTicketsException ge){
			 String message = ge.getMessage();
			 ExceptionBean eb=new ExceptionBean();
			 eb.setErrorCode("602");
			 eb.setErrorMsg(message);
			 return new ResponseEntity<ExceptionBean> (eb,HttpStatus.BAD_REQUEST);
			 
		 }
	

}
