package com.project.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderNotfoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(OrderNotfoundException ie,WebRequest wr) {
	System.out.println("inside myHandler method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	
	
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(CustomerNotFoundException ie,WebRequest wr) {
	System.out.println("inside myHandler method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	
	
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(Exception ie,WebRequest wr) {
	System.out.println("inside myHandler method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	
	
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(NoHandlerFoundException ie,WebRequest wr) {
	System.out.println("inside myHandler method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	
	
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
