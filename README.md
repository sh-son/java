# java8

람다(Lambda) 
  
  메서드로 전달할 수 있는 익명 함수를 단순화한 것이라고 할 수 있다.
  
    4가지 특징
      익명
        이름이 없다
      함수
        특정 클래스 종속 x, 메서드와 같은 형식
      전달
        메서드 인수로 전달, 변수로 저장
      간결성
        코드 간결화

    - 동작 파라미터화 간결(익명 클래스 코드 등 구현 x)
    - 전체 표현식을 함수형 인터페이스의 인스턴스로 취급

    함수형 인터페이스
        - Predicate
            - boolean test(T t);
        - Consumer
            - void accept(T t);
        - Function
            - R apply(T t);
    
    메서드 레퍼런스
        - List::contains;
    
    생성자 레퍼런스
        - Apple::new;
