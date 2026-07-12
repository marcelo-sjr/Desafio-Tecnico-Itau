package com.itau.TransactionsApi.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransactionRequest(@NotNull @Min(0) BigDecimal valor, @NotNull OffsetDateTime dataHora) {}
