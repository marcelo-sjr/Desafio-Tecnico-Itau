package com.itau.TransactionsApi.repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itau.TransactionsApi.domain.Statistics;
import com.itau.TransactionsApi.domain.Transaction;

@Component
public class TransactionRepository {
	
	private final List<Transaction> transactions= new ArrayList<>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public void clearTransactions() {
		transactions.clear();
	}
	
	public Statistics lastMinuteTransactions(){
		
		OffsetDateTime lastMinute = OffsetDateTime.now().minusSeconds(60);
		
		var stats = transactions.stream().filter(
				transaction -> transaction.getDataHora().isAfter(lastMinute))
				.mapToDouble(transaction -> transaction.getValor().doubleValue())
				.summaryStatistics();
		
		if(stats.getCount() == 0) {
			return new Statistics(0L,0.0,0.0,0.0,0.0);
		}
		
		return new Statistics(stats);
	}
}
