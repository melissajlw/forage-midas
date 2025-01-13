package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Balance;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BalanceQuerier {
    // REST template
    private final RestTemplate restTemplate;

    public BalanceQuerier(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    // URL Construction for balance API endpoint
    //      response: Balance type, maps JSON response to Balance object
    //      returns: mapped Balance object
    public Balance query(Long userId) {
        String url = "http://localhost:33400/balance?userId=" + userId;
        return restTemplate.getForObject(url, Balance.class);
    }
}
