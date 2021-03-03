package kr.sooragenius.toy.changer.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@ExtendWith(SpringExtension.class)
@RestClientTest(RestTemplateCurrencyRequest.class)
public class RestTemplateCurrencyRequestTest {
    private final static String SUCCESS_JSON = "{\"success\":true,\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":1614651127,\"source\":\"USD\",\"quotes\":{\"USDAED\":3.673198,\"USDAFN\":78.432676}}";

    @Autowired
    private CurrencyRequest restTemplateCurrencyRequest;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    @Test
    void 정상적으로_처리가_되면은_body를_리턴해야_한다() {
        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("/live"))
                .andRespond(MockRestResponseCreators.withSuccess(SUCCESS_JSON, MediaType.APPLICATION_JSON));

        assertThat(restTemplateCurrencyRequest.request()).isEqualTo(SUCCESS_JSON);
    }

    @Test
    void 정상적인_처리가_아니면인_Exception이_발생해야_한다() {
        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("/live"))
                .andRespond(MockRestResponseCreators.withServerError());

        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> restTemplateCurrencyRequest.request());
    }

}
