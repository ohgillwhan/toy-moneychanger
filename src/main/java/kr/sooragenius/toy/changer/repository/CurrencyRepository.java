package kr.sooragenius.toy.changer.repository;

import kr.sooragenius.toy.changer.domain.Currency;
import kr.sooragenius.toy.changer.domain.CurrencyKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, CurrencyKey> {
}
