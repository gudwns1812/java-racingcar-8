package racingcar.service;

import java.util.List;
import racingcar.domain.NameParser;
import racingcar.domain.Participants;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.WinnerDto;

public class RacingCarService {

    private final NameParser nameParser;
    private final DistanceStrategy distance;

    public RacingCarService(NameParser nameParser, DistanceStrategy distance) {
        this.nameParser = nameParser;
        this.distance = distance;
    }

    public List<WinnerDto> race(String people, int move) {
        Participants participants = nameParser.parseWith(people, distance);
        return participants.race(move);
    }
}
