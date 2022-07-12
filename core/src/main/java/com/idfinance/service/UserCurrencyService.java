package com.idfinance.service;

import com.idfinance.model.UserCurrency;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserCurrencyService {
    UserCurrency save(UserCurrency currency);
    List<UserCurrency> findAll();
    void registerNotificationOnCurrency(String username, String currencySymbol);
}
