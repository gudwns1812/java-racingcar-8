package racingcar.domain;

import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.WinnerDto;

public class Participant {
    private final String name;
    private final DistanceStrategy distance;
    private long totalDistance;

    private Participant(String name , DistanceStrategy distance) {
        this.name = name;
        this.distance = distance;
    }

    public long move(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            totalDistance += distance.calculateDistance();
        }
        return totalDistance;
    }

    public boolean match(long distance) {
        return totalDistance == distance;
    }

    public WinnerDto toDto() {
        return new WinnerDto(name);
    }

    public static Participant nameWith(String name , DistanceStrategy distance) {
        return new Participant(name, distance);
    }
}
