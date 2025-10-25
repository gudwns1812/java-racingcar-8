package racingcar.domain;

import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class Participant {
    private final String name;
    private final DistanceStrategy distance;
    private long totalDistance;

    private Participant(String name, DistanceStrategy distance) {
        this.name = name;
        this.distance = distance;
    }

    public long move() {
        totalDistance += distance.calculateDistance();
        return totalDistance;
    }

    public boolean match(long distance) {
        return totalDistance == distance;
    }

    public RacingResultDto toDto() {
        return new RacingResultDto(name, totalDistance);
    }

    public static Participant nameWith(String name, DistanceStrategy distance) {
        return new Participant(name, distance);
    }
}
