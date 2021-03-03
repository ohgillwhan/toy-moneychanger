package kr.sooragenius.toy.changer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Currency {
    private String source;
    private String fromTo;
    private double rate;


    public String getFrom() {
        return source;
    }
    public String getTo() {
        return fromTo.replace(source, "");
    }
}
