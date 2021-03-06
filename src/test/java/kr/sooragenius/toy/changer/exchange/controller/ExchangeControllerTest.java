package kr.sooragenius.toy.changer.exchange.controller;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.currency.domain.Currency;
import kr.sooragenius.toy.changer.exchange.dto.ExchangeRequestDTO;
import kr.sooragenius.toy.changer.exchange.dto.ExchangeResponseDTO;
import kr.sooragenius.toy.changer.currency.enums.CurrencyType;
import kr.sooragenius.toy.changer.currency.service.CurrencyService;
import kr.sooragenius.toy.changer.exchange.vo.PrettyDouble;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.ModelMap;
import org.springframework.validation.ObjectError;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExchangeController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureJson
@AutoConfigureJsonTesters
class ExchangeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GsonTester<ExchangeResponseDTO.Exchange> gsonTester;

    @MockBean
    private CurrencyService currencyService;
    private Gson gson = new Gson();

    @ParameterizedTest
    @ValueSource(ints = {-1, 10001})
    void 범위에_들어오지_않을경우(int amount) throws Exception {
        // given
        ExchangeRequestDTO.Exchange exchange = new ExchangeRequestDTO.Exchange(CurrencyType.USD, CurrencyType.KRW, amount);
        Currency currency = new Currency("USD", "USDKRW", 1200);

        given(currencyService.findById(any()))
                .willReturn(currency);

        // when
        MvcResult mvcResult = mockMvc.perform(
                post("/exchange")
                        .param("source", exchange.getSource().name())
                        .param("destination", exchange.getDestination().name())
                        .param("amount", String.valueOf(exchange.getAmount()))
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        // then
        ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
        List<ObjectError> errors = (List<ObjectError>) modelMap.get("errors");

        assertThat(errors).isNotEmpty();
        assertThat(mvcResult.getModelAndView().getViewName()).isEqualTo("index");
    }
    @Test
    void exchange() throws Exception {
        // given
        ExchangeRequestDTO.Exchange exchange = new ExchangeRequestDTO.Exchange(CurrencyType.USD, CurrencyType.KRW, 1000);
        Currency currency = new Currency("USD", "USDKRW", 1200);

        given(currencyService.findById(any()))
                .willReturn(currency);

        // when
        MvcResult mvcResult = mockMvc.perform(
                post("/exchange")
                        .param("source", exchange.getSource().name())
                        .param("destination", exchange.getDestination().name())
                        .param("amount", String.valueOf(exchange.getAmount()))
        )
                .andExpect(status().isOk())
                .andReturn();

        // then
        ModelMap modelMap = mvcResult.getModelAndView().getModelMap();

        JsonContent<ExchangeResponseDTO.Exchange> parse = gsonTester.write((ExchangeResponseDTO.Exchange) modelMap.get("exchangeResult"));

        assertThat(parse)
                .extractingJsonPathStringValue("source").isEqualTo(CurrencyType.USD.name());
        assertThat(parse)
                .extractingJsonPathStringValue("destination").isEqualTo(CurrencyType.KRW.name());
        assertThat(parse)
                .extractingJsonPathNumberValue("amount").isEqualTo(exchange.getAmount());
        assertThat(parse)
                .extractingJsonPathNumberValue("receivableAmount.value").isEqualTo(exchange.getAmount() * currency.getRate());
    }
}