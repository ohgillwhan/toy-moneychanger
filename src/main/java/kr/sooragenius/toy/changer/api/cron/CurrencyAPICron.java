package kr.sooragenius.toy.changer.api.cron;

import kr.sooragenius.toy.changer.api.service.CurrencyAPICaller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CurrencyAPICron implements ApplicationRunner {
    private final CurrencyAPICaller currencyAPICaller;


    @Scheduled(cron = "${currency.api.cron.expression}")
    private void schedule() {
        log.info("Start Schedule");
        currencyAPICaller.call()
                .forEach(System.out::println);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        schedule();
    }
}
