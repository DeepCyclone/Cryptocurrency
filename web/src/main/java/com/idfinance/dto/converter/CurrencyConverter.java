package com.idfinance.dto.converter;

import com.idfinance.dto.response.CurrencyResponseDto;
import com.idfinance.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyConverter {

    CurrencyConverter INSTANCE = Mappers.getMapper(CurrencyConverter.class);

    CurrencyResponseDto fromModel(Currency currency);
    List<CurrencyResponseDto> fromModels(List<Currency> currency);
    Currency toModel(CurrencyResponseDto currency);
}
