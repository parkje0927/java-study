package com.study.database.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class UncheckedTest {

    /**
     * RuntimeException 을 상속 받은 예외는 언체크 예외가 된다.
     */

    @Test
    void uncheckedCatchTest() {
        TestService service = new TestService();
        service.callCatch();
    }

    @Test
    void uncheckedThrowTest() {
        TestService service = new TestService();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyUncheckedException.class);
    }

    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    /**
     * uncheck 예외는 예외를 잡거나, 던지지 않아도 된다.
     * 에외를 잡지 않으면 자동으로 밖으로 던진다.
     */
    static class TestService {
        TestRepository testRepository = new TestRepository();

        //필요한 경우 예외를 잡아서 처리, 가만히 두면 예외를 던진다.
        public void callCatch() {
            try {
                testRepository.call();
            } catch (MyUncheckedException e) {
                log.error("언체크 예외, message = {}", e.getMessage(), e);
            }
        }

        //예외 선언 안 해도 던져진다.
        public void callThrow() {
            testRepository.call();
        }
    }

    static class TestRepository {
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }
}
