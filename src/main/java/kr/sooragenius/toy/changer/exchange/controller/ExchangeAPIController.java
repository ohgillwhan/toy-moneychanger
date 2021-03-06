package kr.sooragenius.toy.changer.exchange.controller;

import kr.sooragenius.toy.changer.currency.domain.Currency;
import kr.sooragenius.toy.changer.currency.domain.CurrencyKey;
import kr.sooragenius.toy.changer.exchange.dto.ExchangeRequestDTO;
import kr.sooragenius.toy.changer.exchange.dto.ExchangeResponseDTO;
import kr.sooragenius.toy.changer.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeAPIController {
    private final CurrencyService currencyService;

    private final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/exchange-rate")
    public ResponseEntity<ExchangeResponseDTO.ExchangeRate> currencyRate(ExchangeRequestDTO.ExchangeRate exchangeRate) {
        CurrencyKey currencyKey = new CurrencyKey(exchangeRate.getSource(), exchangeRate.getDestination());
        Currency currency = currencyService.findById(currencyKey);

        ExchangeResponseDTO.ExchangeRate resultExchangeRate = modelMapper.map(currency, ExchangeResponseDTO.ExchangeRate.class);

        return ResponseEntity.ok(resultExchangeRate);
    }
}
