package kr.sooragenius.toy.changer.exchange.dto;

import kr.sooragenius.toy.changer.currency.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ExchangeRequestDTO {
    @Data
    public static class ExchangeRate {
        private CurrencyType source = CurrencyType.USD;
        private CurrencyType destination;
    }
    @Data
    @NoArgsConstructor @AllArgsConstructor
    public static class Exchange {
        private CurrencyType source = CurrencyType.USD;
        private CurrencyType destination;
        @Min(0) @Max(10000)
        @NotNull
        private Integer amount;
    }
}
