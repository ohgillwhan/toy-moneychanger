package kr.sooragenius.toy.changer.dto;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

public class ExchangeResponseDTO {
    @Data
    public static class ExchangeRate {
        private CurrencyType source;
        private CurrencyType destination;
        private double rate;

        public String getRatePretty() {
            DecimalFormat form = new DecimalFormat("#,##0.##");
            return form.format(rate);
        }
    }
    @Data
    @NoArgsConstructor @AllArgsConstructor
    public static class Exchange {
        private CurrencyType source;
        private CurrencyType destination;
        private int amount;
        private double rate;
        private double receivableAmount;

        public String getReceivableAmountPretty() {
            DecimalFormat form = new DecimalFormat("#,##0.##");
            return form.format(receivableAmount);
        }
    }
}
