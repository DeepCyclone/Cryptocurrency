package com.idfinance.repository;

import com.idfinance.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long>,CustomCurrencyRepository {
    Currency findCurrencyBySymbol(String symbol);
}
