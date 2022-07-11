package com.idfinance.fetcher;

import com.idfinance.dto.request.CurrencyRequestDto;
import com.idfinance.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableScheduling
public class FetchScheduler {

    private final CurrencyService currencyService;
    private final RestTemplate restTemplate;

    @Autowired
    public FetchScheduler(CurrencyService currencyService) {
        this.currencyService = currencyService;
        this.restTemplate = new RestTemplateBuilder().build();
    }

    @Scheduled(fixedDelay = 1000*60)
    public void scheduleFixedDelayTask() {
        final String url = "https://api.coinlore.net/api/ticker/?id=90,80,48543";
        CurrencyRequestDto[] objects = restTemplate.getForObject(url, CurrencyRequestDto[].class);
        System.out.println(Arrays.toString(objects));
    }
}
