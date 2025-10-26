package racingcar.service;

import java.util.List;
import racingcar.domain.RacingEntrance;
import racingcar.domain.RacingGame;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class RacingCarService {

    private final RacingEntrance nameParser;
    private final DistanceStrategy distance;
    private RacingGame participants;

    public RacingCarService(RacingEntrance nameParser, DistanceStrategy distance) {
        this.nameParser = nameParser;
        this.distance = distance;
    }

    public List<RacingResultDto> race(String people) {
        participants = nameParser.enter(people, distance);
        return participants.race();
    }

    public List<RacingResultDto> chooseWinner() {
        return participants.chooseWinner();
    }
}
