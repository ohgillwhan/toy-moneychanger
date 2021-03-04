package kr.sooragenius.toy.changer.api.cron;

import kr.sooragenius.toy.changer.api.service.CurrencyAPICaller;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.mockito.Mockito.*;

@WebMvcTest(properties = {"currency.api.cron.expression=*/5 * * * * *"})
@Import(
        CurrencyAPICron.class
)
class CurrencyAPICronTest {
    @MockBean
    private CurrencyAPICaller currencyAPICaller;


    @Test
    void 시작시_한번_5초뒤_한번_호출이_되어_총_2번_되어야_한다() throws InterruptedException {
        verify(currencyAPICaller, atMostOnce())
                .call();
        Thread.sleep(5000);
        verify(currencyAPICaller, atLeast(2))
                .call();
    }

}