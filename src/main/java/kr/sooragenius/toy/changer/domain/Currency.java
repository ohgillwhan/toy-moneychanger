package kr.sooragenius.toy.changer.domain;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Currency {
    private CurrencyType from;
    private CurrencyType to;
    private double rate;

    public Currency(String source, String fromTo, double rate) {
        Assert.notNull(source, "source는 notNull 여야 합니다.");
        Assert.notNull(fromTo, "fromTo는 notNull 여야 합니다.");
        this.from = CurrencyType.valueOf(source);
        this.to = CurrencyType.valueOf(fromTo.substring(source.length()));
        this.rate = rate;
    }
}
