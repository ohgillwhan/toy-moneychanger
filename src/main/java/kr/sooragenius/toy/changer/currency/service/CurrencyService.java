package kr.sooragenius.toy.changer.currency.service;

import kr.sooragenius.toy.changer.currency.domain.Currency;
import kr.sooragenius.toy.changer.currency.domain.CurrencyKey;
import kr.sooragenius.toy.changer.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Transactional
    public List<Currency> deleteAllAndSaveALl(List<Currency> list) {
        currencyRepository.deleteAll();
        return currencyRepository.saveAll(list);
    }
    @Transactional(readOnly = true)
    public Currency findById(CurrencyKey currencyKey) {
        return currencyRepository.findById(currencyKey).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 환전 정보 입니다."));
    }
}
