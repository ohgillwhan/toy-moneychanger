package kr.sooragenius.toy.changer.request;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateCurrencyRequest implements CurrencyRequest{
    private final RestTemplate restTemplate;

    @Override
    public String request() {
        return restTemplate.exchange("", HttpMethod.GET, null, String.class).getBody();
    }
}
