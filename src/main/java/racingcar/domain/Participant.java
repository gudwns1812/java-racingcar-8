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

    public int move() {
        int currentDistance = distanceStrategy.calculateDistance();
        if (currentDistance >= 4) {
            totalDistance += currentDistance;
        }
        return totalDistance;
    }

    public boolean match(int distance) {
        return totalDistance == distance;
    }

    public RacingResultDto toDto() {
        return new RacingResultDto(name, totalDistance);
    }

    public static Participant nameWith(String name, DistanceStrategy distance) {
        return new Participant(name, distance);
    }
}
