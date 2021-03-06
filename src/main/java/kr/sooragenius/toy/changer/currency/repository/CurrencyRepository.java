package kr.sooragenius.toy.changer.currency.repository;

import kr.sooragenius.toy.changer.currency.domain.Currency;
import kr.sooragenius.toy.changer.currency.domain.CurrencyKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, CurrencyKey> {
}
