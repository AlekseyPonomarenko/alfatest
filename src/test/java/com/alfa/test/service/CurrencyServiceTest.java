package com.alfa.test.service;

import com.alfa.test.feign.CurrencyFeignClient;
import com.alfa.test.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.alfa.test.model.CurrencyTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @MockBean
    private CurrencyFeignClient currencyFeignClient;

    @Value("${openexchangerates.app_id}")
    private String app_id;

    @Test
    void compareCurrencyByCode() {

        given(currencyFeignClient.getRate(app_id)).willReturn(CurrencyTest.getCurrencyOld());
        given(currencyFeignClient.getRateHistorical("date", app_id)).willReturn(CurrencyTest.getCurrencyNew());

        Currency rateToDay = currencyFeignClient.getRate(app_id);
        Currency rateYesterday = currencyFeignClient.getRateHistorical("date", app_id);
        boolean res = currencyService.compareCurrencyByCode(rateToDay, rateYesterday, "RUB", "EUR");
        assertEquals(currencyService.compareCurrencyByCode(rateToDay, rateYesterday, "RUB", "EUR"), true);

    }
}