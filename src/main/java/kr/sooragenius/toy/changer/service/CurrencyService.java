package kr.sooragenius.toy.changer.service;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.repository.CurrencyRepository;
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
}
