package racingcar.dto;

public class RacingResultDto {
    private final String name;
    private final long distance;

    public RacingResultDto(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }
}
