package com.alfa.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
public class Currency {

    private String base;
    private Map<String, BigDecimal> rates;

    public BigDecimal getValueByCode(String currency){

        if (currency.equals(base)) {
            return new BigDecimal(1);
        };

       return getRates().get(currency);

    }

}
