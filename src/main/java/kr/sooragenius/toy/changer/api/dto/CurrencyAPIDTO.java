package kr.sooragenius.toy.changer.api.dto;

import lombok.Data;

import java.util.Map;


public class CurrencyAPIDTO {
    @Data
    public static class Response {
        private boolean success;
        private String source;
        private Map<String, Double> quotes;
    }
}
