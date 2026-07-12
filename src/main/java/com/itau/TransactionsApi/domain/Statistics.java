package com.itau.TransactionsApi.domain;

import java.util.DoubleSummaryStatistics;

public class Statistics{
	
	Long count; 
	Double sum;
	Double avg;
	Double min;
	Double max;
	
	public Statistics(DoubleSummaryStatistics statistics) {
		this.count = statistics.getCount();
		this.sum = statistics.getSum();
		this.avg = statistics.getAverage();
		this.min = statistics.getMin();
		this.max = statistics.getMax();
	}

	public Long getCount() {
		return count;
	}

	public Double getSum() {
		return sum;
	}

	public Double getAvg() {
		return avg;
	}

	public Double getMin() {
		return min;
	}

	public Double getMax() {
		return max;
	}

	@Override
	public String toString() {
		return "Statistics [count=" + count + ", sum=" + sum + ", avg=" + avg + ", min=" + min + ", max=" + max + "]";
	}
	
	
}
