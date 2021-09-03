package com.alfa.test.service;

import com.alfa.test.feign.CurrencyFeignClient;
import com.alfa.test.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@PropertySource("classpath:application.properties")
public class CurrencyService implements CurrencyServiceImpl {

    @Autowired
    private CurrencyFeignClient currencyFeignClient;

    @Value("${openexchangerates.app_id}")
    private String app_id;

    @Override
    public Currency getCurrency() {
        return currencyFeignClient.getRate(app_id);
    }

    @Override
    public Currency getCurrency(String date) {
        return currencyFeignClient.getRateHistorical(date, app_id);
    }

    @Override
    public boolean compareCurrencyByCode(Currency newCurrency, Currency oldCurrency, String etalonCode, String reqestCode) {

        Double newDelta = deltaRate(newCurrency.getValueByCode(reqestCode), newCurrency.getValueByCode(etalonCode));
        Double oldDelta = deltaRate(oldCurrency.getValueByCode(reqestCode), oldCurrency.getValueByCode(etalonCode));

        return (newDelta > oldDelta);
    }

    private Double deltaRate(BigDecimal c1, BigDecimal c2) {
        Double res = c1.doubleValue() / c2.doubleValue();
        return res;
    }


}
