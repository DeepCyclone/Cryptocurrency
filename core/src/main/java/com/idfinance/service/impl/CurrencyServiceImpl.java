package com.idfinance.service.impl;

import com.idfinance.model.Currency;
import com.idfinance.repository.CurrencyRepository;
import com.idfinance.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> fetchCurrencies(int page,int size){
        final Page<Currency> currencyPage = currencyRepository.findAll(PageRequest.of(page-1, size));
        return currencyPage.getContent();
    }

    @Override
    public Currency fetchCurrencyBySymbol(String symbol){
        return currencyRepository.findCurrencyBySymbol(symbol);
    }

    @Transactional
    @Override
    public void updateCurrencies(List<Currency> currencies) {
        currencyRepository.updateCurrencies(currencies);
    }

    @Override
    public void notify(String username,String currencySymbol){

    }
}
