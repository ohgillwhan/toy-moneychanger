- [X] API 통신을 하여 제대로된 값을 가져오는지 확인을 한다. ( 단지 확인용 -> 테스트 코드 X )
- [X] API 결과값은 DTO로 받아와야 한다. => CurrencyAPIService.getCurrenciesListFromAPI(): List<CurrencyResponse>
    - [X] HTTP를 요청할 때 구현체를 거쳐서 요청을 한다.
    - [X] Currency는 From(Source)를 갖고 있어야 한다.
    - [X] Currency는 금액 비율을 갖고 있어야 한다. ( double )
    - [X] Currency는 From(Source) / To 를 나눠서 가져와야 한다.
    - [X] From, To는 Enum 이여야 한다. ( https://currencylayer.com/site_downloads/cl-currencies-select-option.txt )
    - [X] success값이 false이면 Exception이 발생해야 한다.
- [ ] API 요청하는 구현체는 RestTemplate으로 구현을 한다.
    - [X] 정상적으로 처리가 되면은 body를 return 해야 한다.
    - [ ] API의 access_token 은 환경변수로 설정한다.
    - [ ] status가 2xx이 아닐경우 Exception을 발생시킨다.