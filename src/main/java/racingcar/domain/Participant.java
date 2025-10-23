package racingcar.domain;

import racingcar.dto.WinnerDto;

public class Participant {
    private String name;
    private long totalDistance;

    private Participant(String name) {
        this.name = name;
    }

    public long move(String moveCount) {
        Distance distance = Distance.startRacing(moveCount);
        totalDistance = distance.calculateDistance();
        return totalDistance;
    }

    public boolean match(long distance) {
        return totalDistance == distance;
    }

    public WinnerDto toDto() {
        return new WinnerDto(name, totalDistance);
    }

    public static Participant nameWith(String name) {
        return new Participant(name);
    }
}
