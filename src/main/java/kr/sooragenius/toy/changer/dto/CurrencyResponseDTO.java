package kr.sooragenius.toy.changer.dto;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.Data;

public class CurrencyResponseDTO {
    @Data
    public static class ExchangeRate {
        private CurrencyType source;
        private CurrencyType destination;
        private double rate;
    }
}
