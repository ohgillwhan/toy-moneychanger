package kr.sooragenius.toy.changer.api.service;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.currency.domain.Currency;
import kr.sooragenius.toy.changer.api.dto.CurrencyAPIDTO;
import kr.sooragenius.toy.changer.api.exception.APIFailureException;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CurrencyAPICaller {
    private final CurrencyRequest currencyRequest;
    private final Gson gson = new Gson();

    @Retryable(value = Exception.class, maxAttemptsExpression = "${currency.api.retry.maxAttemptsExpression}", backoff = @Backoff(delayExpression = "${currency.api.retry.delayExpression}"))
    public List<Currency> call() {
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
