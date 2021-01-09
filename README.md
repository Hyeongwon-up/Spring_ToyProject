# Spring_ToyProject

## Spring 프레임워크.

## DI(Dependency Injection) 컨테이너 제공 -> 쉽게 부품을 교체하듯이 개발 가능.

역활과 구현을 분리하자!!  모든 설계에 Interface 부여.

## SOLID 생각하면서 설계 
(좋은 객체지향 5가지 원칙)

>S : SRP(Single Responsibility Priciple) -> 한 클래스는 하나의 책임.클라이언트 객체는 실행하는 책임만 담당.   
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

#### IoC(Inversion of Control) 제어의 역전  
+ 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다.   
  AppConfig는 OrderServiceImpl이 아닌 OrderService 인터페이스의 다른 구현 객체를 생성하고 실행할수 있다.    
  그런 사실도 모른채 OrderServiceImpl은 묵묵히 자신의 로직 실행   
  => 프로그램의 제어 흐름을 직접 제어하는것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라 한다.
  
#### 프레임워크 vs 라이브러리

+ 프레임워크가 내가 작성한 코드를 제어하고 대신 실행 -> 프레임워크 맞음 (Junit).   
+ 내가 작성한 코드가 직접 제어의 흐름을 담당 -> 라이브러리.   


#### 의존관계 주입 DI(Dependency Injection)

+ 의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각.
+ 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경 할 수 있음.

#### IoC 컨테이너, DI 컨테이너

+ AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결 해 주는 것을 의미.   
  최근에는 주로 DI 컨테이너라 한다. 또는 어셈블러, 오브젝트 펙토리 등으로 불리기도 한다.
***



