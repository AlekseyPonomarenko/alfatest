package com.alfa.test.service;

import com.alfa.test.model.Currency;
import com.alfa.test.model.CurrencyTest;
import com.alfa.test.model.PictureTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class RateServiceTest {

    @Autowired
    private RateServiceImpl rateService;

    @MockBean
    private CurrencyServiceImpl currencyService;

    @MockBean
    private PictureServiseImpl pictureServise;

    @Value("${rub_code}")
    private String rub_code;

    @Value("${tag_rich}")
    private String tag_rich;

    @Value("${tag_broke}")
    private String tag_broke;

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    private String formatString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Test
    void rate() {

        given(currencyService.getCurrency()).willReturn(CurrencyTest.getCurrencyNew());
        Currency rateToDay = currencyService.getCurrency();

        given(currencyService.getCurrency(formatString(yesterday()))).willReturn(CurrencyTest.getCurrencyOld());
        Currency rateYesterday = currencyService.getCurrency(formatString(yesterday()));

        given(pictureServise.getPictureByTag(tag_rich)).willReturn(PictureTest.getPicture(tag_rich));
        given(pictureServise.getPictureByTag(tag_broke)).willReturn(PictureTest.getPicture(tag_broke));

        given(currencyService.compareCurrencyByCode(rateYesterday, rateToDay, rub_code, "EUR")).willReturn(true);

        assertEquals(rateService.rate("EUR"), tag_rich);

    }

}
