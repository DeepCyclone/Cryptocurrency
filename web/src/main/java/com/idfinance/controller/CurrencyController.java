package com.idfinance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
    @GetMapping
    public ResponseEntity<String> retrieveAllCurrencies(@RequestParam String page,@RequestParam String limit){
        return new ResponseEntity<>("123", HttpStatus.OK);
    }
    @GetMapping(value = "/{id:\\d+}")
    public ResponseEntity<String> retrieveCurrencyInfo(@RequestParam String currencyName, @PathVariable String id){
        return new ResponseEntity<>("123", HttpStatus.OK);
    }
}
