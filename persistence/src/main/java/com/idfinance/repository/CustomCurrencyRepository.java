package com.idfinance.repository;

import com.idfinance.model.Currency;

import java.util.List;

public interface CustomCurrencyRepository {
    void updateCurrencies(List<Currency> currencies);
}
