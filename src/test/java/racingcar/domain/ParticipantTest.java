package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.distance.FixedDistanceStrategy;

class ParticipantTest {

    private Participant participant;

    @Test
    @DisplayName("0이하가 반복회수로 오면 예외를 발생시킨다.")
    void move_is_Positive() {
        //given
        participant = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        int input = -1;
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> participant.move());
    }
}