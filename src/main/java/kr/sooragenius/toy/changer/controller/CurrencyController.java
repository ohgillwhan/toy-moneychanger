package kr.sooragenius.toy.changer.controller;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import kr.sooragenius.toy.changer.dto.CurrencyRequestDTO;
import kr.sooragenius.toy.changer.dto.CurrencyResponseDTO;
import kr.sooragenius.toy.changer.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    private final ModelMapper modelMapper = new ModelMapper();
    @RequestMapping(value = {"/", ""})
    public String index(@ModelAttribute("exchangeResult") CurrencyResponseDTO.Exchange exchangeResult) {

        return "index";
    }

    @PostMapping("/exchange")
    public String exchange(@ModelAttribute CurrencyRequestDTO.Exchange exchange, ModelMap modelMap) {
        CurrencyKey currencyKey = new CurrencyKey(exchange.getSource(), exchange.getDestination());
        Currency currency = currencyService.findById(currencyKey);

        double receivableAmount = currency.calcReceivableAmount(exchange.getAmount());

        CurrencyResponseDTO.Exchange exchangeResult = modelMapper.map(exchange, CurrencyResponseDTO.Exchange.class);
        modelMapper.map(currency, exchangeResult);
        exchangeResult.setReceivableAmount(receivableAmount);

        modelMap.addAttribute("exchangeResult", exchangeResult);

        return "exchange";
    }
}
