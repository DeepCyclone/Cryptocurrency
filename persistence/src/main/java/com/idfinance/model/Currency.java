package com.idfinance.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Currency {
    private long id;
    private String name;
    private BigDecimal price;
}
