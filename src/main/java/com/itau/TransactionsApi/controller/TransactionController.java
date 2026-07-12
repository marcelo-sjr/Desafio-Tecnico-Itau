package com.itau.TransactionsApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.TransactionsApi.domain.TransactionRequest;
import com.itau.TransactionsApi.domain.TransactionResponse;
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
	ResponseEntity<TransactionResponse> newTransaction(@RequestBody @Valid TransactionRequest dto) {
		TransactionResponse response = service.validarTransacao(dto);
		return ResponseEntity.ok(response);
	}
}
