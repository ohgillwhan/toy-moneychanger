package kr.sooragenius.toy.changer.service;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.enums.CurrencyType;
import kr.sooragenius.toy.changer.exception.APIFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CurrencyAPIServiceTest {
    private final static String SUCCESS_JSON = "{\"success\":true,\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":1614651127,\"source\":\"USD\",\"quotes\":{\"USDAED\":3.673198,\"USDAFN\":78.432676}}";
    private final static String NOT_SUCCESS_JSON = "{\"success\":true,\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":1614651127,\"source\":\"USD\"}";



    @DisplayName("정상적인 Json이면은 정상적인 CurrencyResponse가 리턴이 되어야 한다.")
    @Test
    void 정상적인_json이면은_정상적인_CurrencyResponse가_리턴되어야_한다() {
        // given
        CurrencyAPIService currencyAPIService = new CurrencyAPIService(() -> CurrencyAPIServiceTest.SUCCESS_JSON, new Gson());
        // when
        List<Currency> currencies = currencyAPIService.getCurrenciesListFromAPI();

        // then
        Currency aed = currencies.get(0);
        Currency afn = currencies.get(1);

        assertCurrency(aed, CurrencyType.USD, CurrencyType.AED, 3.673198);
        assertCurrency(afn, CurrencyType.USD, CurrencyType.AFN, 78.432676);
    }

    @DisplayName("성공하지 못한 Json이면은 Exception이 발생해야 한다.")
    @Test
    void 성공하지_못한_Json이면은_Exception이_발생해야_한다() {
        CurrencyAPIService currencyAPIService = new CurrencyAPIService(() -> CurrencyAPIServiceTest.NOT_SUCCESS_JSON, new Gson());

        assertThatExceptionOfType(APIFailureException.class)
                .isThrownBy(() -> currencyAPIService.getCurrenciesListFromAPI());
    }


    private void assertCurrency(Currency currency, CurrencyType exceptFrom, CurrencyType exceptTo, double exceptRate) {
        assertThat(currency.getFrom()).isEqualTo(exceptFrom);
        assertThat(currency.getTo()).isEqualTo(exceptTo);
        assertThat(currency.getRate()).isEqualTo(exceptRate);
    }
}
