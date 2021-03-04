package kr.sooragenius.toy.changer.api.service;

import kr.sooragenius.toy.changer.api.exception.APIFailureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCurrencyRequest implements CurrencyRequest{
    private final RestTemplate restTemplate;

    @Value("${currency.api.endpoint}")
    private String apiEndpoint;

    public RestTemplateCurrencyRequest(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String request() {
        ResponseEntity<String> exchange = restTemplate.exchange(apiEndpoint, HttpMethod.GET, null, String.class);
        if(!exchange.getStatusCode().is2xxSuccessful()) throw new APIFailureException();

        return exchange.getBody();
    }
}
