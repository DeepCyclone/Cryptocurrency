package com.idfinance.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data

public class CurrencyRequestDto implements Serializable {
    private String symbol;
    @JsonProperty("price_usd")
    private BigDecimal price;
}
