package com.alfa.test.service;

import com.alfa.test.model.Currency;
import com.alfa.test.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
@PropertySource("classpath:application.properties")
public class RateService implements RateServiceImpl {

    @Autowired
    private CurrencyServiceImpl currencyService;

    @Autowired
    private PictureServiseImpl pictureServise;

    @Value("${rub_code}")
    private String rub_code;

    @Value("${tag_rich}")
    private String tag_rich;

    @Value("${tag_broke}")
    private String tag_broke;

    @Override
    public String rate(String requestCurrency) {

        Currency rateToDay = currencyService.getCurrency();
        Currency rateYesterday = currencyService.getCurrency(formatString(yesterday()));

        String tag;

        if (currencyService.compareCurrencyByCode(rateYesterday, rateToDay, rub_code, requestCurrency)) {
            tag = tag_rich;
        } else
            {
            tag = tag_broke;
        };

        Picture picture = pictureServise.getPictureByTag(tag);
        return picture.getData().getEmbedUrl();

    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    private String formatString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }


}
