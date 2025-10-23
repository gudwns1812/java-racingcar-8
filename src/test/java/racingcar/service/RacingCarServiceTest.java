package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Participant;
import racingcar.domain.Participants;
import racingcar.domain.RacingTrack;
import racingcar.dto.WinnerDto;

class RacingCarServiceTest {

    private RacingCarService service;
    private RacingTrack track;

    @BeforeEach
    void setUp() {
        track = new RacingTrack();
        service = new RacingCarService(track);
    }

    @Test
    void move_participant() {
        //given
        track.participateBy(Participants.participate("name"));
        String moveCount = "4";
        //when
        List<WinnerDto> race = service.race(moveCount);
        //then
        assertThat(race.size()).isEqualTo(1);
    }
}