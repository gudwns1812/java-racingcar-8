package racingcar.service;

import java.util.List;
import racingcar.domain.NameParser;
import racingcar.domain.Participants;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class RacingCarService {

    private final NameParser nameParser;
    private final DistanceStrategy distance;
    private Participants participants;

    public RacingCarService(NameParser nameParser, DistanceStrategy distance) {
        this.nameParser = nameParser;
        this.distance = distance;
    }

    public List<RacingResultDto> race(String people) {
        participants = nameParser.parseWith(people, distance);
        return participants.race();
    }

    public List<RacingResultDto> chooseWinner() {
        return participants.chooseWinner();
    }
}
