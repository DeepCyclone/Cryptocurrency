package com.idfinance.repository;

import com.idfinance.model.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCurrencyRepository extends JpaRepository<UserCurrency,String> {
}
