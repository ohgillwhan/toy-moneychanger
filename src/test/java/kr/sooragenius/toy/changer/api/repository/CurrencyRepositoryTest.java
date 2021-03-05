package kr.sooragenius.toy.changer.api.repository;

import kr.sooragenius.toy.changer.api.service.CurrencyAPICaller;
import kr.sooragenius.toy.changer.api.service.CurrencyAPICallerTest;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import kr.sooragenius.toy.changer.enums.CurrencyType;
import kr.sooragenius.toy.changer.repository.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CurrencyRepositoryTest {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private EntityManager entityManager;
    private final static String SUCCESS_JSON = "{\"success\":true,\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":1614651127,\"source\":\"USD\",\"quotes\":{\"USDAED\":3.673198,\"USDAFN\":78.432676}}";

    @Test
    public void 저장_테스트() {
        // given
        CurrencyAPICaller currencyAPICaller = new CurrencyAPICaller(() -> SUCCESS_JSON);
        List<Currency> currencies = currencyAPICaller.call();
        // when
        currencyRepository.save(currencies.get(0));
        currencyRepository.save(currencies.get(1));
        entityManager.flush();
        entityManager.clear();
        // then
        Currency aed = currencyRepository.findById(new CurrencyKey(CurrencyType.USD, CurrencyType.AED)).orElseThrow(() -> new IllegalArgumentException());
        Currency afn = currencyRepository.findById(new CurrencyKey(CurrencyType.USD, CurrencyType.AFN)).orElseThrow(() -> new IllegalArgumentException());

        assertCurrency(aed, CurrencyType.USD, CurrencyType.AED, 3.673198);
        assertCurrency(afn, CurrencyType.USD, CurrencyType.AFN, 78.432676);

    }


    private void assertCurrency(Currency currency, CurrencyType exceptFrom, CurrencyType exceptTo, double exceptRate) {
        assertThat(currency.getSource()).isEqualTo(exceptFrom);
        assertThat(currency.getDestination()).isEqualTo(exceptTo);
        assertThat(currency.getRate()).isEqualTo(exceptRate);
    }

}