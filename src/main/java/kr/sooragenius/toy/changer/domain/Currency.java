package kr.sooragenius.toy.changer.domain;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.Getter;

@Getter
public class Currency {
    private CurrencyType from;
    private CurrencyType to;
    private double rate;

    public Currency(String source, String fromTo, double rate) {
        this.from = CurrencyType.valueOf(source);
        this.to = CurrencyType.valueOf(fromTo.replace(source, ""));
        this.rate = rate;
    }
}
