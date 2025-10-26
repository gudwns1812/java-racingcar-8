package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.domain.distance.FixedDistanceStrategy;

class ParticipantTest {

    private Participant participant;

    @Test
    void 반복회수로_0이하가_오면_예외를_발생시킨다() {
        //given
        participant = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        int input = -1;
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> participant.move());
    }
}