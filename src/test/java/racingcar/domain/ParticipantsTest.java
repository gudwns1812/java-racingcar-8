package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.distance.FixedDistanceStrategy;
import racingcar.dto.RacingResultDto;

class ParticipantsTest {

    @Test
    @DisplayName("참가자가 2명 이상 일때 우승자 계산")
    void move_participant_with_multiplayer() {
        //given
        Participant p1 = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        Participant p2 = Participant.nameWith("hug", new FixedDistanceStrategy(5));
        RacingGroup participants = new RacingGroup(List.of(p1, p2));
        //when
        List<RacingResultDto> winners = participants.chooseWinner();
        //then
        assertThat(winners.getFirst().name()).isEqualTo("hug");
    }

    @Test
    @DisplayName("우승자가 2명 이상 일 경우 테스트")
    void multi_winners() {
        //given
        Participant p1 = Participant.nameWith("toby", new FixedDistanceStrategy(4));
        Participant p2 = Participant.nameWith("hug", new FixedDistanceStrategy(4));
        RacingGroup participants = new RacingGroup(List.of(p1, p2));
        //when
        List<RacingResultDto> winners = participants.chooseWinner();
        //then
        assertThat(winners.size()).isEqualTo(2);
    }
}