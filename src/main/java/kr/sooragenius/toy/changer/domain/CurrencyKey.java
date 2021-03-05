package kr.sooragenius.toy.changer.domain;

import kr.sooragenius.toy.changer.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class CurrencyKey implements Serializable {
    private CurrencyType source;
    private CurrencyType destination;
}
