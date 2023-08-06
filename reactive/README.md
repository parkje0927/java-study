# Spring Webflux 완전 정복 : 코루틴부터 리액티브 MSA 프로젝트까지
## 대답할 수 있어야 하는 질문들
- 동기와 비동기, Blocking 과 Non-Blocking 의 차이는 무엇인가요?
- Reactive System 의 필수 요소는 무엇인가요?
- Reactive Streams 는 어떤 구조로 되어 있나요?
- java nio 는 어떻게 동작하나요? java io 와의 차이는 무엇인가요?
- Reactor pattern 을 사용해서 어떤 일을 할 수 있나요?
- Reactive 란 무엇인가요?

# 동기와 비동기, Blocking 과 Non-Blocking 의 차이는?
## 동기와 비동기
### Caller 와 Callee
- 함수가 다른 함수를 호출하는 상황 => Caller 가 Callee 를 call 했다.
- Caller : 호출하는 함수
- Callee : 호출 당하는 함수

### 함수형 인터페이스
- 1개의 추상 메서드를 갖고 있는 인터페이스
- 함수를 1급 객체로 사용할 수 있다.
  - 함수를 변수에 할당하거나 인자로 전달하고 반환값으로 사용 가능
- Function, Consumer, Supplier, Runnable 등
- 함수형 인터페이스로 구현한 익명 클래스를 람다식으로 변경 가능
- 함수형 인터페이스는 호출한 쓰레드에서 실행된다.

### 동기와 비동기
- 동기 : Caller 는 Callee 의 결과에 관심이 있다. Caller 는 결과를 이용해서 action
- 비동기 : Caller 는 Callee 의 결과에 관심이 없다. Callee 는 결과를 이용해서 callback 수행

## Blocking 과 Non-Blocking
### Blocking
- Callee 를 호출한 후 Callee 가 완료되기 전까지 Caller 가 아무것도 할 수 없다.
- 제어권을 Callee 가 가지고 있다.
- Caller 는 Callee 가 완료될때까지 대기
- 별도의 thread 가 필요하지 않다.

### Non-Blocking
- Caller 는 Callee 를 기다리지 않고 본인의 일을 한다.
- 제어권을 Caller 가 가지고 있다.
- Caller 와 다른 별도의 스레드가 필요하다.

## Blocking 종류
- CPU-bound blocking : 오랜 시간 일을 한다.
- IO-bound blocking : 오랜 시간 대기를 한다.

## CompletableFuture 클래스
### Future
- 비동기적인 작업을 수행
- 해당 작업이 완료되면 결과를 반환

### CompletionStage
- 비동기적인 작업을 수행
- 해당 작업이 완료되면 결과를 처리하거나 다른 CompletionStage 를 연결하는 인터페이스

## Future 인터페이스
### ExecutorService
- 쓰레드 풀을 이용하여 비동기적으로 작업을 실행하고 관리
- 쓰레드 풀을 이용하여 자원을 효율적으로 관리

<br>

- getFuture : 새로운 쓰레드를 생성하여 1을 반환
- getFutureCompleteAfter1S : 새로운 쓰레드를 생성하고 1초 대기 후 1을 반환
- get() : 결과를 구할때까지 쓰레드가 계속 block
- get(long timeout, TimeUnit unit) : timout 동안 쓰레드가 block

### Future 인터페이스의 한계
- cancel 을 제외하고 외부에서 future 을 컨트롤 할 수 없다.
- 반환된 결과를 get() 해서 접근하기 때문에 비동기 처리가 어렵다.
- 완료되거나 에러가 발생했는지 구분이 어렵다.