package com.idfinance.service;

import com.idfinance.model.Currency;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyService {
    List<Currency> fetchCurrencies(int page, int size);
    Currency fetchCurrencyBySymbol(String symbol);
    void updateCurrencies(List<Currency> currencies);
    void notify(String username,String currencySymbol);
}
