package kr.sooragenius.toy.changer.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponse {
    private boolean success;
    private String source;
    private Map<String, Double> quotes;
}
