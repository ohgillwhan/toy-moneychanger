package kr.sooragenius.toy.changer.service;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.dto.CurrencyResponse;
import kr.sooragenius.toy.changer.request.CurrencyRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CurrencyAPIService {
    private final CurrencyRequest currencyRequest;
    private final Gson gson;

    public List<Currency> parseFromAPI() {
        String payload = currencyRequest.request();

        CurrencyResponse currencyResponse = gson.fromJson(payload, CurrencyResponse.class);

        return currencyResponse.getQuotes()
                .entrySet()
                .stream()
                .map(quote -> new Currency(currencyResponse.getSource(), quote.getKey(), quote.getValue()))
                .collect(Collectors.toList());
    }
}
