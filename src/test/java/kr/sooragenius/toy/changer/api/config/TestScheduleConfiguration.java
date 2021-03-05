package kr.sooragenius.toy.changer.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@ComponentScan("kr.sooragenius.toy.changer.api.cron")
public class TestScheduleConfiguration {
}
