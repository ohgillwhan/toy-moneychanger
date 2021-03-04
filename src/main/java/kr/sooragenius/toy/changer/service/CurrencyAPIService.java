package kr.sooragenius.toy.changer.service;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.dto.CurrencyAPIDTO;
import kr.sooragenius.toy.changer.exception.APIFailureException;
import kr.sooragenius.toy.changer.request.CurrencyRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CurrencyAPIService {
    private final CurrencyRequest currencyRequest;
    private final Gson gson;

    public List<Currency> getCurrenciesListFromAPI() {
        String payload = currencyRequest.request();

        CurrencyAPIDTO.Response response= gson.fromJson(payload, CurrencyAPIDTO.Response.class);
        if(!response.isSuccess() || response.getQuotes() == null) throw new APIFailureException();

        return response.getQuotes()
                .entrySet()
                .stream()
                .map(quote -> new Currency(response.getSource(), quote.getKey(), quote.getValue()))
                .collect(Collectors.toList());
    }
}
