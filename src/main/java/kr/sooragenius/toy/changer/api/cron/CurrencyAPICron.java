package kr.sooragenius.toy.changer.api.cron;

import kr.sooragenius.toy.changer.api.service.CurrencyAPICaller;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CurrencyAPICron implements ApplicationRunner {
    private final CurrencyAPICaller currencyAPICaller;
    private final CurrencyService currencyService;


    @Scheduled(cron = "${currency.api.cron.expression}")
    private void schedule() {
        log.info("Start Schedule");
        List<Currency> call = currencyAPICaller.call();
        currencyService.saveAll(call);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        schedule();
    }
}
