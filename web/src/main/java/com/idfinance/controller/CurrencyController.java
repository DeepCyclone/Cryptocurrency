package com.idfinance.controller;

import com.idfinance.dto.converter.CurrencyConverter;
import com.idfinance.dto.response.CurrencyResponseDto;
import com.idfinance.model.Currency;
import com.idfinance.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CurrencyConverter currencyConverter;

    @Autowired

    public CurrencyController(CurrencyService currencyService, CurrencyConverter currencyConverter) {
        this.currencyService = currencyService;
        this.currencyConverter = currencyConverter;
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponseDto>> retrieveAllCurrencies(@RequestParam(defaultValue = "1",required = false) int page,
                                                                           @RequestParam(defaultValue = "1",required = false) int limit){
        final List<Currency> currencies = currencyService.fetchCurrencies(page,limit);
        final List<CurrencyResponseDto> currenciesDtos = currencyConverter.fromModels(currencies);
        return new ResponseEntity<>(currenciesDtos, HttpStatus.OK);
    }
    @GetMapping(value = "/{id:\\d+}")
    public ResponseEntity<String> retrieveCurrencyInfo(@RequestParam String currencyName, @PathVariable String id){
        return new ResponseEntity<>("123", HttpStatus.OK);
    }

    @PostMapping(value = "/notify")
    public ResponseEntity<Void> notify(@RequestParam String username,@RequestParam String currencySymbol){
        return new ResponseEntity(HttpStatus.OK);
    }
}
