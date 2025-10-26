package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;

public class RacingEntrance {
    private static final String NAME_DELIMITER = ",";

    public RacingGame enter(String people, DistanceStrategy distanceStrategy) {
        List<String> names = List.of(people.split(NAME_DELIMITER));
        validateNameLength(names);
        return RacingGame.racingGroupBy(names, distanceStrategy);
    }

    private void validateNameLength(List<String> names) {
        names.forEach(RacingEntrance::limitNameLength);
    }

    private static void limitNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다.");
        }
    }
}
