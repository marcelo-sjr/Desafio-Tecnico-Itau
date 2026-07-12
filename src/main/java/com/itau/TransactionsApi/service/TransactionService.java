package com.itau.TransactionsApi.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.itau.TransactionsApi.domain.TransactionRequest;
import com.itau.TransactionsApi.domain.TransactionResponse;

@Service
public class TransactionService {
	
	public TransactionResponse validarTransacao(TransactionRequest dto) {
		return new TransactionResponse(BigDecimal.ZERO,OffsetDateTime.now());
	}
}
