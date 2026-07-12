package com.itau.TransactionsApi.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;

public record TransactionResponse(@NotNull BigDecimal valor, @NotNull OffsetDateTime dataHora) {}
