package com.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {
   
	@ExceptionHandler(RuntimeException.class)
	public String exception() {
		return "404";
	}
	
}
