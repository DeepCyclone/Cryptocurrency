package com.idfinance.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.idfinance"} )
@EnableJpaRepositories(basePackages = {"com.idfinance"})
@Configuration
public class ApplicationConfig {
}
