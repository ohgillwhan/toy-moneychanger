package kr.sooragenius.toy.changer.controller;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import kr.sooragenius.toy.changer.dto.ExchangeRequestDTO;
import kr.sooragenius.toy.changer.dto.ExchangeResponseDTO;
import kr.sooragenius.toy.changer.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ExchangeController {
    private final CurrencyService currencyService;

    private final ModelMapper modelMapper = new ModelMapper();
    @RequestMapping(value = {"/", ""})
    public String index(@ModelAttribute("request") ExchangeRequestDTO.Exchange exchangeResult) {

        return "index";
    }

    @PostMapping("/exchange")
    public String exchange(@Valid @ModelAttribute("request") ExchangeRequestDTO.Exchange exchange, BindingResult bindingResult, ModelMap modelMap) {
        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("errors", bindingResult.getAllErrors());
            return index(exchange);
        }

        CurrencyKey currencyKey = new CurrencyKey(exchange.getSource(), exchange.getDestination());
        Currency currency = currencyService.findById(currencyKey);

        double receivableAmount = currency.calcReceivableAmount(exchange.getAmount());

        ExchangeResponseDTO.Exchange exchangeResult = modelMapper.map(exchange, ExchangeResponseDTO.Exchange.class);
        modelMapper.map(currency, exchangeResult);
        exchangeResult.setReceivableAmount(receivableAmount);

        modelMap.addAttribute("exchangeResult", exchangeResult);

        return "exchange";
    }
}
