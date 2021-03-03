package kr.sooragenius.toy.changer.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@Import(
        RestTemplateCurrencyRequest.class
)
public class MockRestTemplateCurrencyRequestTest {
    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyRequest restTemplateCurrencyRequest;


    @Test
    void 정상적으로_처리가_되면은_body를_리턴해야_한다() {
        // given
        final String body = "HELLO, WORLD!";
        given(restTemplate.exchange(anyString(), any(), any(), (Class)any()))
                .willReturn(ResponseEntity.ok(body));

        // when
        String result = restTemplateCurrencyRequest.request();

        // then
        assertThat(result).isEqualTo(body);
    }

}
