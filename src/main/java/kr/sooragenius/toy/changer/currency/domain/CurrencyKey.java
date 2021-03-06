package kr.sooragenius.toy.changer.currency.domain;

import kr.sooragenius.toy.changer.currency.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class CurrencyKey implements Serializable {
    private CurrencyType source;
    private CurrencyType destination;
}
