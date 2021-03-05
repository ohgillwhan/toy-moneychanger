- [X] API 통신을 하여 제대로된 값을 가져오는지 확인을 한다. ( 단지 확인용 -> 테스트 코드 X )
- [X] API 결과값은 DTO로 받아와야 한다. => CurrencyAPIService.getCurrenciesListFromAPI(): List<CurrencyResponse>
    - [X] HTTP를 요청할 때 구현체를 거쳐서 요청을 한다.
    - [X] Currency는 Source를 갖고 있어야 한다.
    - [X] Currency는 금액 비율을 갖고 있어야 한다. ( double )
    - [X] Currency는 Source / Destination 를 나눠서 가져와야 한다.
    - [X] Source, Desitnation는 Enum 이여야 한다. ( https://currencylayer.com/site_downloads/cl-currencies-select-option.txt )
    - [X] success값이 false이면 Exception이 발생해야 한다.
- [X] API 요청하는 구현체는 RestTemplate으로 구현을 한다.
    - [X] 정상적으로 처리가 되면은 body를 return 해야 한다.
    - [X] API의 access_token 은 환경변수로 설정한다.
    - [X] status가 2xx이 아닐경우 Exception을 발생시킨다.
- [X] API는 호출 시간은 application.properties에 정의가 되어서 그것 기반으로 호출이 되어야 한다.
    - [X] 시작시에는 무조건 실행이 되어야 한다.
    - [X] API 호출은 실패시 여러번 호출이 되어야 하고, application.properties에 정의된 데이터에 맞게 움직여야 한다.
    - [X] 호출이 되면은 DB에 데이터가 삭제 된 후 저장이 되어야 한다.
- [X] 페이지는 주어진 양식과 같아야 한다.
    - [X] 무조건 source는 USD로 고정한다
    - [X] 수취국가를 바꾸면은 환율을 바꿔줘야 한다.
    - [ ] 송금액을 입력후 돈을 건네면은 계산되어 나와야 한다. 
    