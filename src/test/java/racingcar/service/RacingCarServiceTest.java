package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingEntrance;
import racingcar.domain.distance.FixedDistanceStrategy;
import racingcar.dto.RacingResultDto;

class RacingCarServiceTest {

    private RacingCarService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarService(new RacingEntrance(), new FixedDistanceStrategy(4));
    }

    @Test
    void 참가자가_1명이면_참가자가_우승자가_된다() {
        //given
        String input = "toby";
        //when
        List<RacingResultDto> race = service.race(input);
        //then
        assertThat(race.size()).isEqualTo(1);
    }
}