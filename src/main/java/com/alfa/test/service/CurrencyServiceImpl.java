package com.alfa.test.service;

import com.alfa.test.model.Currency;

public interface CurrencyServiceImpl {

    Currency getCurrency();
    Currency getCurrency(String date);
    boolean compareCurrencyByCode(Currency newCurrency, Currency oldCurrency, String etalonCode, String reqestCode);

}
