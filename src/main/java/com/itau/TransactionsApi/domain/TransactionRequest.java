package com.itau.TransactionsApi.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransactionRequest(@NotNull BigDecimal valor, @NotNull OffsetDateTime dataHora) {}
