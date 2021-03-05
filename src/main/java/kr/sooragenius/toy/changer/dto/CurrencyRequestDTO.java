package kr.sooragenius.toy.changer.dto;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CurrencyRequestDTO {
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
        private int amount;
    }
}
