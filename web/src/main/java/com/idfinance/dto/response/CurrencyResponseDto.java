package com.idfinance.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyResponseDto {
    private long id;
    private String symbol;
    private BigDecimal price;
}
