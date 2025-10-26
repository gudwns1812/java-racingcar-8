package racingcar.service;

import java.util.List;
import racingcar.domain.RacingEntrance;
import racingcar.domain.RacingGame;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class RacingCarService {

    private final RacingEntrance racingEntrance;
    private final DistanceStrategy distance;
    private RacingGame racingGame;

    public RacingCarService(RacingEntrance racingEntrance, DistanceStrategy distanceStrategy) {
        this.racingEntrance = racingEntrance;
        this.distance = distanceStrategy;
    }

    public List<RacingResultDto> race(String people) {
        racingGame = racingEntrance.enter(people, distance);
        return racingGame.race();
    }

    public List<RacingResultDto> chooseWinner() {
        return racingGame.chooseWinner();
    }
}
