package racingcar.domain.distance;

public abstract class DistanceStrategy {
    public void validateDistance() {}
    public abstract int calculateDistance();
}
