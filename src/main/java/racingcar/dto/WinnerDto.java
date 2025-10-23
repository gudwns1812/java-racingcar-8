package racingcar.dto;

public class WinnerDto {
    private String name;
    private long distance;

    public WinnerDto(String name, long distance) {
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
