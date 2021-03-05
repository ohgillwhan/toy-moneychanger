package kr.sooragenius.toy.changer.api.cron;

import kr.sooragenius.toy.changer.api.config.TestScheduleConfiguration;
import kr.sooragenius.toy.changer.api.service.CurrencyAPICaller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.lang.annotation.*;

import static org.mockito.Mockito.*;


@ExtendWith({SpringExtension.class})
@Import(
        CurrencyAPICron.class
)
@TestPropertySource(properties = "currency.api.cron.expression=*/5 * * * * *")
@SpringJUnitConfig(TestScheduleConfiguration.class)
class CurrencyAPICronTest {
    @MockBean
    private CurrencyAPICaller currencyAPICaller;

    @Test
    void 시작시_한번_5초뒤_한번_호출이_되어_총_2번_되어야_한다() throws InterruptedException {
        verify(currencyAPICaller, atMostOnce())
                .call();
        Thread.sleep(6000);
        verify(currencyAPICaller, atLeast(2))
                .call();
    }

}