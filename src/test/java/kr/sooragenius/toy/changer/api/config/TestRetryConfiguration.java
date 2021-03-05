package kr.sooragenius.toy.changer.api.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;

@Configuration
@EnableRetry
public class TestRetryConfiguration {
}
