package racingcar.domain;

import racingcar.dto.RacingResultDto;

public class Participant {
    private final String name;
    private final Distance distance;

    private Participant(String name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Participant nameWith(String name, Distance distance) {
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
        distance.move();
    }

    public boolean match(Distance target) {
        return distance.equals(target);
    }

    public Distance getDistance() {
        return distance;
    }

    public RacingResultDto toDto() {
        return new RacingResultDto(name, distance.toResultDto());
    }
}
