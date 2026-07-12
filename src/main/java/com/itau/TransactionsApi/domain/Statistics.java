package com.itau.TransactionsApi.domain;

import java.util.DoubleSummaryStatistics;

public class Statistics{
	
	long count; 
	double sum;
	double avg;
	double min;
	double max;

	public Statistics(Long count, Double sum, Double avg, Double min, Double max) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
	}
	
	public Statistics(DoubleSummaryStatistics stats) {
		this.count = stats.getCount();
		this.sum = stats.getSum();
		this.avg = stats.getAverage();
		this.min = stats.getMin();
		this.max = stats.getMax();
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
