package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.distance.RandomDistanceStrategy;

public class RacingEntrance {
    private static final String NAME_DELIMITER = ",";

    public RacingGame createRacingGame(String people) {
        validateBlank(people);
        List<Participant> participants = Arrays.stream(people.split(NAME_DELIMITER))
                .map(name -> Participant.nameWith(name, new RandomDistanceStrategy()))
                .toList();

        return RacingGame.createRacingGame(participants);
    }

    private void validateBlank(String people) {
        if (people.isBlank()) {
            throw new IllegalArgumentException("빈칸은 입력할 수 없습니다.");
        }
    }
}
