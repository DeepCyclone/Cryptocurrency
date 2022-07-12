package com.idfinance.fetcher;

import com.idfinance.dto.converter.CurrencyConverter;
import com.idfinance.dto.request.CurrencyRequestDto;
import com.idfinance.model.Currency;
import com.idfinance.model.UserCurrency;
import com.idfinance.service.CurrencyService;
import com.idfinance.service.UserCurrencyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Configuration
@EnableScheduling
public class FetchScheduler {

    private static final Logger LOGGER = LogManager.getLogger(FetchScheduler.class);

    private final CurrencyService currencyService;
    private final UserCurrencyService userCurrencyService;
    private final CurrencyConverter currencyConverter;
    private final RestTemplate restTemplate;
    private static final String url = "https://api.coinlore.net/api/ticker/?id=90,80,48543";
    private static final BigDecimal NOTIFICATION_MULTIPLIER = new BigDecimal("1.01");

    @Autowired
    public FetchScheduler(CurrencyService currencyService, UserCurrencyService userCurrencyService, CurrencyConverter currencyConverter) {
        this.currencyService = currencyService;
        this.userCurrencyService = userCurrencyService;
        this.currencyConverter = currencyConverter;
        this.restTemplate = new RestTemplateBuilder().build();
    }

    @Scheduled(fixedDelay = 1000*60)
    public void fetchCurrencies() {
        CurrencyRequestDto[] objects = restTemplate.getForObject(url, CurrencyRequestDto[].class);
        final List<Currency> currencies = currencyConverter.toModels(List.of(objects));
        currencyService.updateCurrencies(currencies);
    }

    @Scheduled(fixedDelay = 1000*60)
    public void checkRegisteredCurrencies(){
        final List<Currency> currencies = currencyService.fetchCurrencies(1, 10);
        final List<UserCurrency> usersCurrencies = userCurrencyService.findAll();
        if(currencies.isEmpty() || usersCurrencies.isEmpty()){
            return;
        }
        usersCurrencies.forEach(userCurrency->{
            currencies.forEach(validCurrency->{
                if(userCurrency.getSymbol().equals(validCurrency.getSymbol()) &&
                        userCurrency.getFixedPrice().multiply(NOTIFICATION_MULTIPLIER).compareTo(validCurrency.getPrice()) < 0){
                    LOGGER.warn(validCurrency.getSymbol() + "|" + userCurrency.getUsername() + "|" + BigDecimal.ONE.subtract(userCurrency.getFixedPrice().divide(validCurrency.getPrice(),4, RoundingMode.HALF_DOWN)));
                }
            });
        });
    }
}

