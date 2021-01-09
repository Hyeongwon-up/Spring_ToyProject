# Spring_ToyProject

## Spring 프레임워크.

## DI(Dependency Injection) 컨테이너 제공 -> 쉽게 부품을 교체하듯이 개발 가능.

역활과 구현을 분리하자!!  모든 설계에 Interface 부여.

## SOLID 생각하면서 설계 
(좋은 객체지향 5가지 원칙)

>S : SRP(Single Responsibility Priciple) -> 한 클래스는 하나의 책임.   
>    클라이언트 객체는 실행하는 책임만 담당.   
>O : OCP(Open Closed Principle) -> 확장에는 열려있으나 변경에는 닫현있는 원칙.   
>L : LSP(Liskov Substituition Principle) ->   인터페이스 => 구현체.   
>I : ISP(Interface Segregation Principle) -> 특정 클라이언트를 위한 인터페이스 구현.   
>D : DIP(Dependency Inversion Principle) -> 추상화에 의존한다. 구체화에 의존 x.  

 

****
### 1/9
할인 정책 변경.

문제점
> 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다 . => DIP 위반.   
> 정책을 변경할 때,OrderServiceImp를 코드를 수정해줘야한다. => OCP 위반.   


해결
AppConfig 생성 - 애플리케이션의 전체 동작방식 구성하기 위해, 구현 객체를 생성하고, 연결하는 별도의 설정 클래스 생성.   
+ 역활과 구현 클래스가 한눈에 들어오도록. -> 빠르게 파악가능.


***

### 1/10



