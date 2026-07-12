package com.itau.TransactionsApi.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.itau.TransactionsApi.domain.Statistics;
import com.itau.TransactionsApi.domain.Transaction;
import com.itau.TransactionsApi.domain.TransactionRequest;
import com.itau.TransactionsApi.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository repository;
	
	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public void validateTransaction(TransactionRequest dto) {
		
		if(dto.valor().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Value must be higher or equal to 0!");
		}
		
		if(dto.dataHora().isAfter(OffsetDateTime.now())) {
			throw new IllegalArgumentException("Invalid date, it must be prior to this moment!");
		}
		
	}
	
	public void saveTransaction(TransactionRequest dto) {
		repository.addTransaction(new Transaction(dto));
	}
	
	public void deleteAllTransactions() {
		repository.clearTransactions();
	}
	
	public Statistics calculateStatistics() {
		return repository.lastMinuteTransactions();
	}
}
