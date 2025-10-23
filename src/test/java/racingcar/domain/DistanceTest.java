package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    @Test
    @DisplayName("0이하가 반복회수로 오면 예외를 발생시킨다.")
    void move_is_Positive() {
        //given
        String input = "-1";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Distance(input));
    }
    @Test
    @DisplayName("문자가 반복회수로 오면 예외를 발생시킨다.")
    void move_is_number() {
        //given
        String input = "aaa";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Distance(input));
    }
}