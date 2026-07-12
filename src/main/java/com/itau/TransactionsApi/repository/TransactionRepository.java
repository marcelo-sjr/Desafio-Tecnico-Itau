package com.itau.TransactionsApi.repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import com.itau.TransactionsApi.domain.Statistics;
import com.itau.TransactionsApi.domain.Transaction;

public class TransactionRepository {
	
	private List<Transaction> transactions= new ArrayList<>();

	public boolean addTransaction(Transaction transaction) {
		return transactions.add(transaction);
	}
	
	public void clearTransactions() {
		transactions.clear();
	}
	
	public Statistics lastMinuteTransactions(){
		DoubleSummaryStatistics statistics = transactions.stream().filter(
				transaction -> transaction.getDataHora()
				.isAfter(OffsetDateTime.now().minusMinutes(1)))
				.mapToDouble(transaction -> transaction.getValor().doubleValue())
				.summaryStatistics();
		
		return new Statistics(statistics);
	}
}
