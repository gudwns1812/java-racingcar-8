package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.distance.FixedDistanceStrategy;
import racingcar.dto.RacingResultDto;

class ParticipantsTest {

    @Test
    void 참가자가_2명_이상_일때_최대거리가_1명이면_우승자가_1명() {
        //given
        Participant p1 = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        Participant p2 = Participant.nameWith("hug", new FixedDistanceStrategy(5));
        RacingGame racingGame = RacingGame.createRacingGame(List.of(p1, p2));
        //when
        racingGame.race();
        List<RacingResultDto> winners = racingGame.chooseWinner();
        //then
        assertThat(winners.getFirst().name()).isEqualTo("hug");
    }

    @Test
    void 우승자가_2명_이상이_가능하다() {
        //given
        Participant p1 = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        Participant p2 = Participant.nameWith("hug", new FixedDistanceStrategy(4));
        RacingGame racingGame = RacingGame.createRacingGame(List.of(p1, p2));
        //when
        racingGame.race();
        List<RacingResultDto> winners = racingGame.chooseWinner();
        //then
        assertThat(winners.size()).isEqualTo(2);
    }
}