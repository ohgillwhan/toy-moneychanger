package kr.sooragenius.toy.changer.controller;

import com.google.gson.Gson;
import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import kr.sooragenius.toy.changer.dto.CurrencyRequestDTO;
import kr.sooragenius.toy.changer.dto.CurrencyResponseDTO;
import kr.sooragenius.toy.changer.enums.CurrencyType;
import kr.sooragenius.toy.changer.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CurrencyController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureJson
@AutoConfigureJsonTesters
class CurrencyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GsonTester<CurrencyResponseDTO.Exchange> gsonTester;

    @MockBean
    private CurrencyService currencyService;
    private Gson gson = new Gson();
    @Test
    void exchange() throws Exception {
        // given
        CurrencyRequestDTO.Exchange exchange = new CurrencyRequestDTO.Exchange(CurrencyType.USD, CurrencyType.KRW, 1000);
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
        JsonContent<CurrencyResponseDTO.Exchange> parse = gsonTester.write((CurrencyResponseDTO.Exchange) modelMap.get("exchangeResult"));

        assertThat(parse)
                .extractingJsonPathStringValue("source").isEqualTo(CurrencyType.USD.name());
        assertThat(parse)
                .extractingJsonPathStringValue("destination").isEqualTo(CurrencyType.KRW.name());
        assertThat(parse)
                .extractingJsonPathNumberValue("amount").isEqualTo(exchange.getAmount());
        assertThat(parse)
                .extractingJsonPathNumberValue("receivableAmount").isEqualTo(exchange.getAmount() * currency.getRate());
    }
}