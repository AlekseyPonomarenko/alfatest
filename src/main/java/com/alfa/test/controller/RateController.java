package com.alfa.test.controller;

import com.alfa.test.service.RateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

    @Autowired
    private RateServiceImpl rateService;

    @GetMapping("/rate")
    public String rate(@RequestParam String currency) {
        return rateService.rate(currency);
    }
}
