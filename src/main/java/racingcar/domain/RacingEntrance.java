package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;

public class RacingEntrance {
    private static final String NAME_DELIMITER = ",";

    public RacingGame enter(String people, DistanceStrategy distanceStrategy) {
        List<String> names = List.of(people.split(NAME_DELIMITER));
        validateNames(names);
        return createRacingGame(names, distanceStrategy);
    }

    private void validateNames(List<String> names) {
        names.forEach(RacingEntrance::validateName);
    }

    private static void validateName(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (s.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다.");
        }
    }

    private RacingGame createRacingGame(List<String> names, DistanceStrategy distanceStrategy) {
        List<Participant> participants = names.stream()
                .map(s -> Participant.nameWith(s, distanceStrategy))
                .toList();
        return RacingGame.createRacingGame(participants);
    }
}
