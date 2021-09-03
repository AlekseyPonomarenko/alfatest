package com.alfa.test.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyTest {

    public static Currency getCurrencyOld(){
        Map<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
        rates.put("RUB", new BigDecimal(30));
        rates.put("EUR", new BigDecimal(1));
        Currency currency  = new Currency("USD", rates);
        return currency;
    }

    public static Currency getCurrencyNew(){
        Map<String, BigDecimal> rates = new HashMap<String, BigDecimal>();
        rates.put("RUB", new BigDecimal(80));
        rates.put("EUR", new BigDecimal(1));
        Currency currency  = new Currency("USD", rates);
        return currency;
    }

    @Test
    void getValueByCode() {
        Currency currency = getCurrencyOld();
        assertEquals(currency.getBase(),"USD");
        assertEquals(currency.getValueByCode("USD"),new BigDecimal(1));
        assertEquals(currency.getValueByCode("RUB"),new BigDecimal(30));
    }
}