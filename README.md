# Spring_ToyProject
***
### 사용 라이브러리
- [JUnit📄](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)





***

# 공부 및 개발 일지    


## Spring 프레임워크.

## DI(Dependency Injection) 컨테이너 제공 -> 쉽게 부품을 교체하듯이 개발 가능.

역활과 구현을 분리하자!!  모든 설계에 Interface 부여.

## SOLID 생각하면서 설계

(좋은 객체지향 5가지 원칙)

> S : SRP(Single Responsibility Priciple) -> 한 클래스는 하나의 책임.클라이언트 객체는 실행하는 책임만 담당.   
> O : OCP(Open Closed Principle) -> 확장에는 열려있으나 변경에는 닫현있는 원칙.   
> L : LSP(Liskov Substituition Principle) ->   인터페이스 => 구현체.   
> I : ISP(Interface Segregation Principle) -> 특정 클라이언트를 위한 인터페이스 구현.   
> D : DIP(Dependency Inversion Principle) -> 추상화에 의존한다. 구체화에 의존 x.



****


할인 정책 변경.

문제점
> 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다 . => DIP 위반.   
> 정책을 변경할 때,OrderServiceImp를 코드를 수정해줘야한다. => OCP 위반.


해결 AppConfig 생성 - 애플리케이션의 전체 동작방식 구성하기 위해, 구현 객체를 생성하고, 연결하는 별도의 설정 클래스 생성.

+ 역활과 구현 클래스가 한눈에 들어오도록. -> 빠르게 파악가능.

***


### IoC(Inversion of Control) 제어의 역전

+ 내가 호출하는게 아니라 프레임워크가 호출?

+ 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다.   
  AppConfig는 OrderServiceImpl이 아닌 OrderService 인터페이스의 다른 구현 객체를 생성하고 실행할수 있다.    
  그런 사실도 모른채 OrderServiceImpl은 묵묵히 자신의 로직 실행   
  => **프로그램의 제어 흐름을 직접 제어하는것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라 한다.**
  


#### 프레임워크 vs 라이브러리

+ 프레임워크가 내가 작성한 코드를 제어하고 대신 실행 -> 프레임워크 맞음 (Junit).
+ 내가 작성한 코드가 직접 제어의 흐름을 담당 -> 라이브러리.

#### 의존관계 주입 DI(Dependency Injection)

+ **의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각.**
+ 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경 할 수 있음.
+ **애플리케이션 "실행 시점(런타임)" 에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관게가 연결 되는 것을 " 의존관계 주입 " 이라고 한다.**

#### IoC 컨테이너, DI 컨테이너

+ AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결 해 주는 것을 의미.   
  최근에는 주로 DI 컨테이너라 한다. 또는 어셈블러, 오브젝트 펙토리 등으로 불리기도 한다.

#### 스프링 컨테이너

+ "ApplicationContext" 를 스프링 컨테이너라 함.
+ **"@Configuration"** 이 붙은 AppConfig를 설정(구성) 정보로 사용, **"@Bean"**이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록. 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다.
+ 스프링 빈은 "@Bean"이 붙은 메소드의 명을 스프링의 빈의 이름으로 사용. "applicatonContext.getBean()"를 사용하여 메서드를 찾음.

***


#### 스프링 컨테이너 생성

+ 스프링 컨테이너를 생성할 떄는 구성 정보를 지정해주어야 한다.
+ 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.

#### 스프링 빈 의존관계 설정

+ 단순한 자바 코드를 호출한 것 같지만. 아니다. "싱글톤 컨테이너" gogo.

***



#### 테스트

+ 통합테스트 : 스프링 컨테이너 포함
+ 유닛테스트 : 단위 쪼개서 ( 스프링 컨테이너 포함하지 않고) 
+ 유닛테스트에 더 익숙해져야한다.!!!

***



#### 스프링부트 장점

+ 간편한 설정
+ 편리한 의존성 관리 & 자동 권장 버전 관리
+ 내장서버로 인한 간단한 배포 서버 구축
+ 스프링 Security, Data JPA 등의 스프링 프레임워크 요소를 쉽게 사용 할 수있음.


#### AOP ( Asepect Oriented Programming) - 공통관심사항 vs 핵심관심사항 분리! 

### AOP가 필요한 상황!

+ 모든 메소드의 호출시간 측정.
+ 공통 관심사항 ( Cross-cutting concern) vs 핵심 관심 사항( Core concern)
+ 회원가입시간, 회원조회 시간 측정 하고싶을떄?

#### BUT

+ 시간 측정 하는 기능은 핵심 관심사항이 아니다! -> 공통 관심 사항이다.
+ 시간을 측정하는 로직과 비즈니스의 로직이 섞이면 유지보수 어려움



```JAVA
package Hyeongwon.Spring_Practice.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* Hyeongwon.Spring_Practice..*(..)) ")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toLongString());

        try {


            Object result = joinPoint.proceed();
            return result;

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("End: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
    }
}

```









***




