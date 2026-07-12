package com.itau.TransactionsApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.TransactionsApi.domain.TransactionRequest;
import com.itau.TransactionsApi.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("transacao")
public class TransactionController {
	
	private final TransactionService service;
	
	public TransactionController(TransactionService service) {
		this.service = service;
	}
	
	@PostMapping
	ResponseEntity<Void> newTransaction(@RequestBody @Valid TransactionRequest dto) {
		service.validateTransaction(dto);
		service.saveTransaction(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	ResponseEntity<Void> deleteAllTransactions(){
		service.deleteAllTransactions();
		return ResponseEntity.ok().build();
	}
}
