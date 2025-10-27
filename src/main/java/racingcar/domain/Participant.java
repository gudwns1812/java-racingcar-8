package racingcar.domain;

import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class Participant {
    private final String name;
    private final DistanceStrategy distanceStrategy;
    private int totalDistance;

    private Participant(String name, DistanceStrategy distance) {
        this.name = name;
        this.distanceStrategy = distance;
    }

    public static Participant nameWith(String name, DistanceStrategy distance) {
        validateName(name);
        return new Participant(name, distance);
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다.");
        }
    }

    public void move() {
        int currentDistance = distanceStrategy.calculateDistance();

        if (currentDistance >= 4) {
            totalDistance += currentDistance;
        }
    }

    public boolean match(int distance) {
        return totalDistance == distance;
    }

    public void compareDistance(RacingGame racingGame) {
        racingGame.updateMaxDistanceIfLessThan(totalDistance);
    }

    public RacingResultDto toDto() {
        return new RacingResultDto(name, totalDistance);
    }
}
