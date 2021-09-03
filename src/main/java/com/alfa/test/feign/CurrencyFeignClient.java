package com.alfa.test.feign;

import com.alfa.test.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency", url="${openexchangerates.url}")
public interface CurrencyFeignClient {

    @GetMapping(path = "/latest.json", consumes = "application/json")
    public Currency getRate(@RequestParam("app_id") String app_id);

    @GetMapping(path = "/historical/{date}.json", consumes = "application/json")
    public Currency getRateHistorical(@PathVariable("date") String date, @RequestParam("app_id") String app_id);

}
