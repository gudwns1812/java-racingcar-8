package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.distance.RandomDistanceStrategy;

class NameParserTest {

    @Test
    @DisplayName("6이상의 이름에 대해서 예외를 터트린다.")
    void exception_6letter_name() {
        //given
        String input = "aaaaaaaa";
        RacingEntrance nameParser = new RacingEntrance();
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nameParser.enter(input, new RandomDistanceStrategy()));
    }

}