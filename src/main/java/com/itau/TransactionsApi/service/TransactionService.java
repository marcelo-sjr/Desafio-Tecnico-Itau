package com.itau.TransactionsApi.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.itau.TransactionsApi.domain.Transaction;
import com.itau.TransactionsApi.domain.TransactionRequest;
import com.itau.TransactionsApi.exception.CastException;
import com.itau.TransactionsApi.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository repository;
	
	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public void validarTransacao(TransactionRequest dto) {
		
		if(dto.valor().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Value must be higher or equal to 0!");
		}
		
		if(dto.dataHora().isAfter(OffsetDateTime.now())) {
			throw new IllegalArgumentException("Invalid date, it must be prior to this moment!");
		}
		
	}
	
	public void salvarTransacao(TransactionRequest dto) {
		if(!repository.addTransaction(new Transaction(dto))) {
			throw new CastException("Error while casting data.");
		}
	}
}
