package kr.sooragenius.toy.changer.api.service;

import kr.sooragenius.toy.changer.api.config.TestRetryConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@Import(CurrencyAPICaller.class)
@TestPropertySource(properties = {
        "currency.api.retry.maxAttemptsExpression=5",
        "currency.api.retry.delayExpression=100"
})
@SpringJUnitConfig(TestRetryConfiguration.class)
public class CurrencyAPICallerRetryTest {
    @Autowired
    private CurrencyAPICaller currencyAPICaller;

    @MockBean
    private CurrencyRequest currencyRequest;

    @DisplayName("Exception이 발생되면은 최대 N번이 실행되어야 한다.")
    @Test
    void 정상적인_json이면은_정상적인_CurrencyResponse가_리턴되어야_한다() throws InterruptedException {
        // given
        given(currencyRequest.request())
                .willThrow(new RuntimeException("TEST"));
        // then
        try {
            currencyAPICaller.call();
        }catch(Exception ex) {}
        Thread.sleep(1000);
        // when
        verify(currencyRequest, VerificationModeFactory.atLeast(5))
                .request();
    }
}
