package com.study.database.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class CheckedTest {

    //정상 흐름으로 동작해서 테스트 성공한다.
    @Test
    void checkedCatchTest() {
        TestService service = new TestService();
        service.callCatch();
    }
    
    @Test
    void checkedThrowTest() {
        TestService service = new TestService();
        assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MyCheckedException.class);
    }

    /**
     * Exception 을 상속 받은 예외는 체크 예외!!
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    /**
     * 체크 예외는 예외를 잡아서 처리하거나 밖으로 던지거나 둘 중 하나 해야 한다.
     */
    static class TestService {
        TestRepository repository = new TestRepository();

        /**
         * 체크 예외를 잡아서 처리하는 코드
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.error("체크 예외, message = {}", e.getMessage(), e);
            }
        }

        /**
         * 체크 예외를 밖으로 던지는 코드
         *
         * @throws MyCheckedException
         */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }

    }

    static class TestRepository {
        //체크 예외는 밖으로 던질 경우 -> `call() throws MyCheckedException` 과 같이 꼭 선언 해줘야 한다.
        public void call() throws MyCheckedException {
            throw new MyCheckedException("test");
        }
    }
}
