package com.itau.TransactionsApi.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Transaction {
	
	private BigDecimal valor;
	private OffsetDateTime dataHora;
	
	public Transaction(BigDecimal valor, OffsetDateTime dataHora) {
		super();
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	public Transaction(TransactionRequest request) {
		this.valor = request.valor();
		this.dataHora = request.dataHora();
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dataHora, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(valor, other.valor);
	}
	
}
