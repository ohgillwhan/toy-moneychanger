package kr.sooragenius.toy.changer.service;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.request.CurrencyRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyAPIServiceTest {
    private final static String SUCCESS_JSON = "{\"success\":true,\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":1614651127,\"source\":\"USD\",\"quotes\":{\"USDAED\":3.673198,\"USDAFN\":78.432676}}";

    private CurrencyAPIService currencyAPIService = new CurrencyAPIService(() -> CurrencyAPIServiceTest.SUCCESS_JSON, new Gson());

    @DisplayName("정상적인 Json이면은 정상적인 CurrencyResponse가 리턴이 되어야 한다.")
    @Test
    void 정상적인_json이면은_정상적인_CurrencyResponse가_리턴되어야_한다() {
        List<Currency> currencies = currencyAPIService.parseFromAPI();

        Currency aed = currencies.get(0);
        Currency afn = currencies.get(1);

        assertCurrency(aed, "USD", "AED", 3.673198);
        assertCurrency(afn, "USD", "AFN", 78.432676);
    }


    private void assertCurrency(Currency currency, String exceptFrom, String exceptTo, double exceptRate) {
        assertThat(currency.getFrom()).isEqualTo(exceptFrom);
        assertThat(currency.getTo()).isEqualTo(exceptTo);
        assertThat(currency.getRate()).isEqualTo(exceptRate);
    }
}
