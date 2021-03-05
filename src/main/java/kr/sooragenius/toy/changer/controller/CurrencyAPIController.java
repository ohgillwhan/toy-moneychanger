package kr.sooragenius.toy.changer.controller;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import kr.sooragenius.toy.changer.dto.CurrencyRequestDTO;
import kr.sooragenius.toy.changer.dto.CurrencyResponseDTO;
import kr.sooragenius.toy.changer.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyAPIController {
    private final CurrencyService currencyService;

    private final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/currency-rate")
    public ResponseEntity<CurrencyResponseDTO.ExchangeRate> currencyRate(CurrencyRequestDTO.ExchangeRate exchangeRate) {
        CurrencyKey currencyKey = new CurrencyKey(exchangeRate.getSource(), exchangeRate.getDestination());
        Currency currency = currencyService.findById(currencyKey);

        CurrencyResponseDTO.ExchangeRate resultExchangeRate = modelMapper.map(currency, CurrencyResponseDTO.ExchangeRate.class);

        return ResponseEntity.ok(resultExchangeRate);
    }
}
