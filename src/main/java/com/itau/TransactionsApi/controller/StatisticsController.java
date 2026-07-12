package com.itau.TransactionsApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.TransactionsApi.domain.Statistics;
import com.itau.TransactionsApi.service.TransactionService;

@RestController
@RequestMapping("estatistica")
public class StatisticsController {
	
	private final TransactionService service;
	
	public StatisticsController(TransactionService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Statistics> lastMinuteTransactionsStatistics(){
		return ResponseEntity.ok(service.calculateStatistics());
	}
}
