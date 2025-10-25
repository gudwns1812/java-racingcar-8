package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.NameParser;
import racingcar.domain.distance.FixedDistanceStrategy;
import racingcar.dto.RacingResultDto;

class RacingCarServiceTest {

    private RacingCarService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarService(new NameParser(), new FixedDistanceStrategy(4));
    }

    @Test
    @DisplayName("참가자가 1명일 때 우승자 계산")
    void move_participant() {
        //given
        String input = "toby";
        //when
        List<RacingResultDto> race = service.race(input);
        //then
        assertThat(race.size()).isEqualTo(1);
    }
}