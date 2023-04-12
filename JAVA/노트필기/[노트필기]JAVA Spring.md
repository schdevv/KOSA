#### 2023.02.20

### 1. JAVA Spring
#### 1) 개발환경 setting
```
  (1) Eclipse에 spring plugin 설치하는 방법
  (2) STS (Spring Tool Suite) 설치하는 방법 
    □ 다운로드 사이트: https://dist.springsource.com/release/STS/index.html
    □ 파일경로 설정: C드라이브
    □ 인코디 설정 : preference 메뉴-> UTF-8
``` 
#### 2) project 생성 (java project)_step 1~7
```
  (1) project 생성 (java project)_step 1~7 : VO (사용자 id, pw, name)를 jdbc api를 이용해서 DB처리
```
#### 3) code 작성 주의사항: 요구사항에 따른 code의 수정요소가 많음.
```
  (1) How?
    □ 분리성 : SoC Seperation of Concern) 관심사의 분리
    ● 특정 주제에 대한 코드는 한 장소에 존재해야함.
    ● Refactoring : 코드를 효율적으로 재설정 함.
     - method 추출기법 : 중복된 코드를 찾아내 재설정 
    ●  연결정보에 대해 클래스명이 상세히 명시되어있으면 클래스와 메서드간의 tightly Coupled가 발생함. 
  (2) 확장성 : 다른 사용자가 사용할 수 있는 범용성의 개념.
    □ 예시: UserDao를 확장하는 경우
    ● 작성한 UserDao를 타 회사에 판매할 경우
    ● source Code는 제공하지 않음 (무의미 Server code) 
    ● 사용자가 이용할 .class file만 제공
```
#### 4) 상속(Inheritance) : java에서의 대표적인 확장방법
```
  (1) 변할 수 있는 (concern = 주제)코드 부분을 고정시키지 않고               abstract=추상화(구체화하지 않음) 시킴.
  (2) 상속관계의 class
    □ 상위 class : UserDao getConnection() -> 추상화 객체 생성
    □ 하위 class : NUserDao getConnection() -> 직접 객체 생성

  (3) 특징
    □ java는 single Inheritance(단일상속)만을 지원함.
    □ 상속은 class가 tightly coupled 됨 
  (tightly coupled : 클래스안에 다른 클래스명이 명시되는 경우)
    □ 상속을 사용하지 않고 확장성을 가지려면? 분리를 통해 확실하게 두개의 클래스로 분리

```
#### 5)Interface : 단일상속을 피할 수 있는 방법 (의존성 하락)

```
```
#### 6) Design Pattern
```
  (1) Template method pattern : 프로그래밍 확장 구조화 패턴
    □ UserDao : 기본적인 로직처리(흐름)를 갖춘 상위클래스
    □ NUserDao : 로직처리의 기능 일부분만 상속받은 하위클래스 
     -> call_A() , call_B()
  (2) Factory Method Pattern : 구체적인 객체 생성방법을 하위 class에서 결정하는  Design pattern
   □ 하위클래스에서 실제 객체가 만들어지는가에 따라서 해당 클래스의 관계가 설정.

  (3) Strategy Pattern (전략 패턴) : 자신의 기능 context의 일부분을 interface를 통해 통째로 외부로 분리시키는 design pattern
    □ 예시) UserDao가 UserDaoTest를 통해서 전략을 주입받아 SimpleMakeConnection을 사용하는 형태 
    □ 전략을 주입하는 또 다른 객체의 역할을 한 클래스: UserDaoTest
```
#### 7) IoC (Inversion of Control) : 제어의 역전
```
  (1) 제어의 흐름을 거꾸로 뒤집는 현상을 지칭함.
  (2) 객체는 자신이 사용할 객체를 직접 선택하지 않음 (container)
  (3) 객체는 생성하지도 않음.
  (4) Servlet 또한 IoC의 개념임.
```
#### 8) Annotation : @정해져있는 키워드(java) : 직접 만들 수도 있음.
```
  (1) annotation은 주석이라고하지만 주석은 아니다.
  (2)로직에는 영향을 주지않고 대신 program의 구조에 영향을 줌.
  (3) spring에서는 설정값을 잡을 때 주로 사용함.
```
#### 9) Spring의 IoC 
```
  (1) Application Context : 생성, 관계 등 모든 관리를 포괄한 개념
   □ IoC가 적용된 개념.
   □ 설정정보를 통해서 Bean을 관리함.
   □ 설정방법
    ● XML(기본) : 사용하려면 Bean의 Injection에 대한 정보로 기반을 다져야해서 내용이 방대하고 복잡해져 핸들링이 어려움. 문서화되어 가독성에 용이함.
    ● annotation : 코드 작성에 편리함
  (2)Bean Factory : Bean 객체를 생성해내는 역할을 하는 container
  (3) Bean : Spring이 권한을 가지고 직접 만들고 관계를 부여하는 객체이고 Application Context라고 불리는 Bean Factory에 의해 관리됨.
  (4) Meta Data : 구조화된 데이터(속성 정보)
```
#### 10) Bean 
```
 
```