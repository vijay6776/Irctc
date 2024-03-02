package com.demo.exceptionHandling;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ExceptionBean {
	
	private String errorCode;
	private String errorMsg; 

}
