package com.idfinance.service.impl;

import com.idfinance.model.Currency;
import com.idfinance.model.UserCurrency;
import com.idfinance.repository.CurrencyRepository;
import com.idfinance.repository.UserCurrencyRepository;
import com.idfinance.service.UserCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCurrencyServiceImpl implements UserCurrencyService {


    private final UserCurrencyRepository userCurrencyRepository;
    private final CurrencyRepository currencyRepository;

    @Autowired
    public UserCurrencyServiceImpl(UserCurrencyRepository userCurrencyRepository, CurrencyRepository currencyRepository) {
        this.userCurrencyRepository = userCurrencyRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public UserCurrency save(UserCurrency currency) {
        return null;
    }

    @Override
    public List<UserCurrency> findAll() {
        return userCurrencyRepository.findAll();
    }

    @Override
    public void registerNotificationOnCurrency(String username, String currencySymbol) {
        final Currency currency = currencyRepository.findCurrencyBySymbol(currencySymbol);
        userCurrencyRepository.save(UserCurrency.builder().
                username(username).
                symbol(currencySymbol).
                fixedPrice(currency.getPrice()).
                build());
    }
}
