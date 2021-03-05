package kr.sooragenius.toy.changer.domain;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@IdClass(CurrencyKey.class)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Currency {
    @Id @Enumerated(EnumType.STRING)
    private CurrencyType source;
    @Id @Enumerated(EnumType.STRING)
    private CurrencyType destination;


    private double rate;

    public Currency(String source, String sourceAndDestination, double rate) {
        Assert.notNull(source, "source는 notNull 여야 합니다.");
        Assert.notNull(sourceAndDestination, "sourceAndDestination는 notNull 여야 합니다.");
        this.source = CurrencyType.valueOf(source);
        this.destination = CurrencyType.valueOf(sourceAndDestination.substring(source.length()));
        this.rate = rate;
    }

    public double calcRecivableAmount(int amount) {
        return rate * amount;
    }
}
