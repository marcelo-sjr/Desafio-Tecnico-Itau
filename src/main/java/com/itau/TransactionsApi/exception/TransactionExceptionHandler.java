package com.itau.TransactionsApi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> unprocessableEntityHandler(IllegalArgumentException e){
		return ResponseEntity.unprocessableContent().build();
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> globalExceptionHandler(Exception e){
		return ResponseEntity.badRequest().build();
	}
	
}
