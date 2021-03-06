package kr.sooragenius.toy.changer.exchange.dto;

import kr.sooragenius.toy.changer.currency.enums.CurrencyType;
import kr.sooragenius.toy.changer.exchange.vo.PrettyDouble;
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
        private PrettyDouble rate;
        private PrettyDouble receivableAmount;

        public void setRate(double value) {
            this.rate = new PrettyDouble(value);
        }

        public void setReceivableAmount(double receivableAmount) {
            this.receivableAmount = new PrettyDouble(receivableAmount);
        }
    }
}
