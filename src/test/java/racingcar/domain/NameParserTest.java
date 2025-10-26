package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.distance.RandomDistanceStrategy;

class NameParserTest {

    @Test
    void 이름_길이가_6이상이면_예외를_터트린다() {
        //given
        String input = "aaaaaaaa";
        RacingEntrance nameParser = new RacingEntrance();
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nameParser.enter(input, new RandomDistanceStrategy()));
    }
}