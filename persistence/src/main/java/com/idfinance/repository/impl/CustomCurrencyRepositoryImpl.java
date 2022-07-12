package com.idfinance.repository.impl;

import com.idfinance.model.Currency;
import com.idfinance.repository.CustomCurrencyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomCurrencyRepositoryImpl implements CustomCurrencyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateCurrencies(List<Currency> currencies){
        Query q = entityManager.createQuery("update Currency set price = :price where symbol = :symbol");
        currencies.forEach(c->
        {
            q.setParameter("price",c.getPrice());
            q.setParameter("symbol",c.getSymbol());
            q.executeUpdate();
        });
    }
}
