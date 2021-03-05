package kr.sooragenius.toy.changer.controller;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.dto.ExchangeResponseDTO;
import kr.sooragenius.toy.changer.enums.CurrencyType;
import kr.sooragenius.toy.changer.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExchangeAPIController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureJson
@AutoConfigureJsonTesters
class ExchangeAPIControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @Autowired
    GsonTester<ExchangeResponseDTO.ExchangeRate> gsonTester;
    @Test
    void currencyRate() throws Exception {
        // given
        Currency currency = new Currency("USD", "USDKRW", 1500);
        BDDMockito.given(currencyService.findById(any()))
                .willReturn(currency);

        // when
        MvcResult mvcResult = mockMvc.perform(
                get("/exchange-rate")
                        .queryParam("source", "USD")
                        .queryParam("destination", "KRW")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        // then
        ObjectContent<ExchangeResponseDTO.ExchangeRate> parse = gsonTester.parse(mvcResult.getResponse().getContentAsString());

        assertThat(parse)
                .extracting("source").isEqualTo(CurrencyType.USD);
        assertThat(parse)
                .extracting("destination").isEqualTo(CurrencyType.KRW);
        assertThat(parse)
                .extracting("rate").isEqualTo((double)1500);

    }
}