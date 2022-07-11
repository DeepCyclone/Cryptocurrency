package com.idfinance.dto.request;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data

public class CurrencyRequestDto implements Serializable {
    private String id;
    private String symbol;
    private BigDecimal price_usd;
}
